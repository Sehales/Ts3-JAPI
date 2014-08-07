package net.sehales.ts3_japi;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Objects;

import net.sehales.ts3_japi.command.Sendable;

public class QueryReader extends Thread {
    private ServerQuery      query;
    private BufferedReader   in;
    private volatile boolean stop;
    private long             sleep = 5;

    @SuppressWarnings("unused")
    private QueryReader() {}

    QueryReader(ServerQuery query) {
        super("TS3-JAPI_Query-reader");
        this.query = query;

        in = query.br;
        // first get rid of the welcome message, which the ts3 server sends
        // at the beginning of every connection
        try {
            int i = 0;
            while ((i < 4) || in.ready()) {
                // System.out.println(in.readLine());
                in.readLine();
                i++;
            }
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }

    public void end() {
        stop = true;
    }

    public long getSleeptime() {
        return sleep;
    }

    @Override
    public void run() {
        while (!stop) {
            try {
                while (in.ready()) {
                    try {
                        String line = in.readLine();
                        if (!line.isEmpty()) {
                            if (line.startsWith("notify")) {
                                // TODO implement an event system
                                System.out.println("notfiy: " + line);
                            } else {
                                Sendable cmd = query.getCommandQueue().peek();
                                if (Objects.nonNull(cmd) && cmd.isSent()) {
                                    if (line.startsWith("error")) {
                                        cmd.feedError(line.substring(line.indexOf(" "), line.length()));
                                        cmd.setAnswered();
                                        query.getCommandQueue().remove();
                                    } else {
                                        cmd.feedResponse(line);
                                    }
                                }
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } catch (IOException e1) {
                e1.printStackTrace();
            }

            try {
                Thread.sleep(sleep);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void setSleeptime(long sleeptime) {
        sleep = sleeptime;
    }
}
