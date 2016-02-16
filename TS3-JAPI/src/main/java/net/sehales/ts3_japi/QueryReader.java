package net.sehales.ts3_japi;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Objects;

import net.sehales.ts3_japi.command.response.ArrayResponse;
import net.sehales.ts3_japi.exception.QueryException;
import net.sehales.ts3_japi.wrapper.QueryError;

public class QueryReader extends Thread {
    private ServerQuery      query;
    private BufferedReader   in;
    private volatile boolean stop;
    private long             sleep = 5;

    @SuppressWarnings("unused")
    private QueryReader() {}

    QueryReader(ServerQuery query) throws QueryException, IOException {
        super("TS3-JAPI_Query-reader");
        this.query = query;

        in = query.br;
        // first get rid of the welcome message, which the ts3 server sends at the beginning of every connection and check for an error
        int i = 0;
        String line = "";
        while ((i < 4) || in.ready()) {
            line = in.readLine();
            i++;
        }

        if (!(line).isEmpty() && line.startsWith("error")) {
            QueryError error = new QueryError(
                            new ArrayResponse(
                                            line.substring(line.indexOf(" "),
                                                            line.length())).getMap()
                            );

            throw new QueryException(error);
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
                                if (query.isEventManagerPresent()) {
                                    query.getEventManger().parseNotify(line);
                                }
                                if (query.isDebugMode()) {
                                    System.out.printf("Event: %s\n", line);
                                }
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
                                    if (query.isDebugMode()) {
                                        System.out.printf("Response: %s\n", line);
                                    }
                                } else if (query.isDebugMode()) {
                                    System.out.printf("Received unexpected response: %s\n", line);
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
