package net.sehales.ts3_japi;

public abstract class Sendable {

    protected boolean sent;
    protected boolean answered;

    public abstract String buildString();

    public abstract void feedError(String line);

    public abstract void feedResponse(String line);

    public boolean isAnswered() {
        return answered;
    }

    public boolean isSent() {
        return sent;
    }

    public void setAnswered() {
        answered = true;
    }

    public void setSent() {
        sent = true;
    }

}
