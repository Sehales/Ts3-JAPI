package net.sehales.ts3_japi.property;

public enum TextMessageTargetMode implements Property {
    CLIENT(1),
    CHANNEL(2),
    SERVER(3);

    private int index;

    TextMessageTargetMode(int index) {
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
