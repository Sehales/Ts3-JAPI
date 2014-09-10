package net.sehales.ts3_japi.property;

public enum TokenType {
    SERVER_GROUP(0), CHANNEL_GROUP(1);
    private int index;

    TokenType(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }
}
