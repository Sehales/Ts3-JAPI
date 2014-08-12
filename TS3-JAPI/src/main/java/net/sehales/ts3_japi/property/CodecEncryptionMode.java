package net.sehales.ts3_japi.property;

public enum CodecEncryptionMode {
    CODEC_CRYPT_INDIVIDUAL(0),
    CODEC_CRYPT_DISABLED(1),
    CODEC_CRYPT_ENABLED(2);

    private int index;

    CodecEncryptionMode(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }
}
