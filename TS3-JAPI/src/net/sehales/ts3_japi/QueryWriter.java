package net.sehales.ts3_japi;

import java.io.PrintStream;
import java.util.Objects;

import net.sehales.ts3_japi.command.Sendable;

public class QueryWriter extends Thread {
    private ServerQuery      query;
    private int              floodRate = 50;
    private long             sleep     = 5;

    private volatile boolean stop;
    private PrintStream      out;

    @SuppressWarnings("unused")
    private QueryWriter() {}

    QueryWriter(ServerQuery query) {
        super("TS3-JAPI_Query-writer");
        this.query = query;
        out = query.ps;
    }

    public void end() {
        stop = true;
    }

    public int getFloodRate() {
        return floodRate;
    }

    public long getSleeptime() {
        return sleep;
    }

    @Override
    public void run() {
        while (!stop) {
            Sendable cmd = query.getCommandQueue().peek();
            if (Objects.nonNull(cmd) && !cmd.isSent()) {
                out.println(cmd.buildString());
                cmd.setSent();
                query.lastCommand = System.currentTimeMillis();
            }
            try {
                Thread.sleep(sleep);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void setFloodRate(int floodRate) {
        this.floodRate = floodRate;
    }

    public void setSleeptime(long sleeptime) {
        sleep = sleeptime;
    }
}
