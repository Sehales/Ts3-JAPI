package net.sehales.ts3_japi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.function.Consumer;

import net.sehales.ts3_japi.command.Command;
import net.sehales.ts3_japi.command.Sendable;

public class ServerQuery implements AutoCloseable {

    public static void main(String[] args) throws UnknownHostException, IOException {
        // Instant start = Instant.now();
        ServerQuery query = new ServerQuery(new ServerQueryConfig().readerSleeptime(0).writerSleeptime(0).writerFloodrate(0));
        // Instant end = Instant.now();
        // System.out.println(Duration.between(start, end).toMillis());

        // Scanner sc = new Scanner(System.in);
        // String cmd = "";
        // while (true) {
        // cmd = sc.nextLine();
        // if (cmd.equalsIgnoreCase("stop")) {
        // break;
        // }
        // final String c = cmd;
        // Command cmdObj = new Command() {
        // {
        // command = c;
        // }
        // };
        // start = Instant.now();
        // query.doCommand(cmdObj);
        // System.out.println(cmdObj.getResponse().toString());
        // System.out.println(cmdObj.getErrorResponse().toString());
        // end = Instant.now();
        // System.out.printf("took: %d milliseconds\n", Duration.between(start, end).toMillis());
        // }
        List<Command> cmds = new ArrayList<>();
        //@formatter:off
        for (int i = 0; i < 500000; i++) {
            cmds.add(new Command() {{command = "whoami";}});
        }
        //@formatter:on

        Instant start = Instant.now();
        for (Command c : cmds) {
            query.doCommand(c);
        }
        Instant end = Instant.now();
        System.out.println(cmds.size() + " commands took: " + Duration.between(start, end));

        // sc.close();
        query.close();

    }

    private ServerQueryConfig               config;
    private String                          host;
    private int                             port;
    private int                             commandTimeout = 5000;
    private ConcurrentLinkedQueue<Sendable> commandQueue   = new ConcurrentLinkedQueue<>();

    private ServerQueryAPI                  api;
    private Socket                          socket;

    BufferedReader                          br;
    PrintStream                             ps;

    private QueryReader                     queryReader;
    private QueryWriter                     queryWriter;
    long                                    lastCommand    = System.currentTimeMillis();

    @SuppressWarnings("unused")
    private ServerQuery() {}

    public ServerQuery(ServerQueryConfig config) throws UnknownHostException, IOException {
        host = config.host();
        port = config.port();
        this.config = config;
        openConnection();
    }

    public ServerQueryAPI api() {
        ensureOpen();
        if (Objects.nonNull(api)) {
            api = new ServerQueryAPI(this);
        }
        return api;
    }

    @Override
    public void close() {
        ensureOpen();
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

    public synchronized boolean doCommand(Sendable cmd) {
        return doCommand(cmd, commandTimeout);
    }

    public synchronized boolean doCommand(Sendable cmd, int timeout) {
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
        if (!cmd.isAnswered()) {
            return false;
        }
        return true;
    }

    public void doCommandAsync(Command cmd, Consumer<Command> consumer) {
        ensureOpen();
        new Thread(() -> {
            doCommand(cmd);
            consumer.accept(cmd);
        }, "TS3-JAPI_Asynchronous-command-executor")
        .start();
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

    public long getLastCommandTimestamp() {
        return lastCommand;
    }

    private void openConnection() throws UnknownHostException, IOException {
        socket = new Socket(host, port);

        br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
        ps = new PrintStream(socket.getOutputStream(), true, "UTF-8");

        queryReader = new QueryReader(this);
        queryWriter = new QueryWriter(this);
        reloadConfig();
        queryReader.start();
        queryWriter.start();

    }

    public void reloadConfig() {
        queryReader.setSleeptime(config.readerSleeptime());
        queryWriter.setSleeptime(config.writerSleeptime());
        queryWriter.setFloodRate(config.writerFloodrate());
        commandTimeout = config.commandTimeout();
    }
}
