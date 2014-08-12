package net.sehales.ts3_japi.property;

public enum TextMessageTargetMode {
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
}
