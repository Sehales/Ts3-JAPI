package net.sehales.ts3_japi.property;

public enum KickType {

    CHANNEL(4),
    SERVER(5);

    private int index;

    KickType(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }
}
