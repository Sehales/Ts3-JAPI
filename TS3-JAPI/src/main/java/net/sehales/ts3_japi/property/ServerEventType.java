package net.sehales.ts3_japi.property;

public enum ServerEventType implements Property {
    SERVER, CHANNEL, TEXTSERVER, TEXTCHANNEL, TEXTPRIVATE, TOKENUSED;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
