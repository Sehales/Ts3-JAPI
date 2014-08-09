package net.sehales.ts3_japi;

import net.sehales.ts3_japi.command.CmdVersion;

public class HeartbeatThread extends Thread {
    private volatile boolean stop;
    private ServerQuery      query;
    private long             sleep = 1_000;
    private long             rate  = 300_000;

    @SuppressWarnings("unused")
    private HeartbeatThread() {}

    HeartbeatThread(ServerQuery query) {
        this.query = query;
    }

    public void end() {
        stop = true;
    }

    @Override
    public void run() {
        while (!stop) {
            if ((System.currentTimeMillis() - query.lastCommand) > rate) {
                query.send(new CmdVersion());
            }
            try {
                Thread.sleep(sleep);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public void setHeartbeatRate(long rate) {
        this.rate = rate;
    }

    public void setSleepTime(long sleep) {
        this.sleep = sleep;
    }
}
