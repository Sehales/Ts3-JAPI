package net.sehales.ts3_japi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Objects;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

import net.sehales.ts3_japi.command.CmdLogin;
import net.sehales.ts3_japi.event.EventManager;
import net.sehales.ts3_japi.exception.QueryException;

public class ServerQuery implements AutoCloseable {

    public static ServerQuery newConnection(String host, int port, String username, String password) throws IOException, QueryException {
        ServerQuery query = new ServerQuery(new ServerQueryConfig().host(host).port(port));
        CmdLogin login = new CmdLogin(username, password);
        query.send(login);
        if (!login.getError().isOk()) {
            throw new QueryException(login.getError());
        }
        return query;
    }

    private ServerQueryConfig               config;
    private int                             commandTimeout = 5000;

    private ConcurrentLinkedQueue<Sendable> commandQueue   = new ConcurrentLinkedQueue<>();
    private ServerQueryAPI                  api;
    private EventManager                    eventMngr;

    private Socket                          socket;

    BufferedReader                          br;
    PrintStream                             ps;

    private QueryReader                     queryReader;
    private QueryWriter                     queryWriter;
    private HeartbeatThread                 heartbeat;

    long                                    lastCommand    = System.currentTimeMillis();

    private ExecutorService                 executor;

    private boolean                         debugMode;

    @SuppressWarnings("unused")
    private ServerQuery() {}

    public ServerQuery(ServerQueryConfig config) throws IOException, QueryException {
        this.config = config;
        executor = Executors.newFixedThreadPool(config.threadPoolSize());
        openConnection();
    }

    public ServerQueryAPI api() {
        ensureOpen();
        if (Objects.isNull(api)) {
            api = new ServerQueryAPI(this);
        }
        return api;
    }

    @Override
    public void close() {
        ensureOpen();
        if (api != null) {
            api().close();
        }
        try {
            executor.awaitTermination((commandTimeout * commandQueue.size()), TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        heartbeat.end();
        try {
            heartbeat.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        queryWriter.end();
        try {
            queryWriter.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        queryReader.end();
        try {
            queryReader.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void ensureOpen() {
        Objects.requireNonNull(socket);
        if (socket.isClosed()) {
            throw new RuntimeException(new SocketException("Socket has been closed"));
        }
    }

    ConcurrentLinkedQueue<Sendable> getCommandQueue() {
        ensureOpen();
        return commandQueue;
    }

    public ServerQueryConfig getConfig() {
        return config;
    }

    public EventManager getEventManger() {
        if (eventMngr == null) {
            eventMngr = new EventManager(this);
        }
        return eventMngr;
    }

    public long getLastCommandTimestamp() {
        return lastCommand;
    }

    public boolean isDebugMode() {
        return debugMode;
    }

    public boolean isEventManagerPresent() {
        return eventMngr != null;
    }

    public boolean isOpen() {
        return socket.isConnected() && !socket.isClosed();
    }

    private void openConnection() throws IOException, QueryException {
        socket = new Socket(config.host(), config.port(), config.localAddress(), config.localPort());

        br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
        ps = new PrintStream(socket.getOutputStream(), true, "UTF-8");

        queryReader = new QueryReader(this);
        queryWriter = new QueryWriter(this);
        heartbeat = new HeartbeatThread(this);
        reloadConfig();
        queryReader.start();
        queryWriter.start();
        heartbeat.start();
    }

    public void reloadConfig() {
        queryReader.setSleeptime(config.readerSleeptime());
        queryWriter.setSleeptime(config.writerSleeptime());
        queryWriter.setFloodRate(config.writerFloodrate());
        heartbeat.setHeartbeatRate(config.heartbeatRate());
        heartbeat.setSleepTime(config.heartbeatSleeptime());
        commandTimeout = config.commandTimeout();
    }

    public boolean send(Sendable cmd) {
        return send(cmd, commandTimeout);
    }

    public boolean send(Sendable cmd, int timeout) {
        if (cmd.isSent()) {
            throw new UnsupportedOperationException("You may not use a Sendable object twice!");
        }
        ensureOpen();
        long start = System.currentTimeMillis();
        commandQueue.offer(cmd);
        while (!cmd.isAnswered() && ((System.currentTimeMillis() - start) < timeout)) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return cmd.isAnswered();
    }

    public void sendAsync(Sendable cmd, Consumer<Sendable> consumer) {
        ensureOpen();
        executor.execute(() -> {
            send(cmd);
            consumer.accept(cmd);
        });
    }

    public void setDebugMode(boolean turnedOn) {
        debugMode = turnedOn;
    }
}
