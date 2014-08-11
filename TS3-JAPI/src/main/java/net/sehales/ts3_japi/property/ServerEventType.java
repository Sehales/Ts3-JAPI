package net.sehales.ts3_japi.property;

public enum ServerEventType {
    SERVER, CHANNEL, TEXTSERVER, TEXTCHANNEL, TEXTPRIVATE;

    public String getName() {
        return name().toLowerCase();
    }
}
