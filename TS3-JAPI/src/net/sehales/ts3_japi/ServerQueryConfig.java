package net.sehales.ts3_japi;

public class ServerQueryConfig {
    private String host            = "localhost";
    private int    port            = 10011;
    private int    commandTimeout  = 5_000;
    private int    writerFloodrate = 50;
    private long   writerSleeptime = 5;
    private long   readerSleeptime = 5;

    public int commandTimeout() {
        return commandTimeout;
    }

    public ServerQueryConfig commandTimeout(int commandTimeout) {
        this.commandTimeout = commandTimeout;
        return this;
    }

    public String host() {
        return host;
    }

    public ServerQueryConfig host(String host) {
        this.host = host;
        return this;
    }

    public int port() {
        return port;
    }

    public ServerQueryConfig port(int port) {
        this.port = port;
        return this;
    }

    public long readerSleeptime() {
        return readerSleeptime;
    }

    public ServerQueryConfig readerSleeptime(long readerSleeptime) {
        this.readerSleeptime = readerSleeptime;
        return this;
    }

    public int writerFloodrate() {
        return writerFloodrate;
    }

    public ServerQueryConfig writerFloodrate(int writerFloodrate) {
        this.writerFloodrate = writerFloodrate;
        return this;
    }

    public long writerSleeptime() {
        return writerSleeptime;
    }

    public ServerQueryConfig writerSleeptime(long writerSleeptime) {
        this.writerSleeptime = writerSleeptime;
        return this;
    }

}
