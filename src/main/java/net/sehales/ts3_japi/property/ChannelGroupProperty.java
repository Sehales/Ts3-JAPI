package net.sehales.ts3_japi.property;

public enum ChannelGroupProperty implements Property {
    CGID;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
