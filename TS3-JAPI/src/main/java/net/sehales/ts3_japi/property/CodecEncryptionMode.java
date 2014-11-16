package net.sehales.ts3_japi.property;

public enum CodecEncryptionMode implements Property {
    INDIVIDUAL(0),
    DISABLED(1),
    ENABLED(2);

    private int index;

    CodecEncryptionMode(int index) {
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
