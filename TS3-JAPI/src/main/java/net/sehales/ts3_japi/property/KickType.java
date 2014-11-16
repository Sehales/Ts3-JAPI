package net.sehales.ts3_japi.property;

public enum KickType implements Property {

    CHANNEL(4),
    SERVER(5);

    private int index;

    KickType(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
