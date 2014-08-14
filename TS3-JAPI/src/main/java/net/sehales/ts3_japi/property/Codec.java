package net.sehales.ts3_japi.property;

public enum Codec {
    SPEEX_NARROWBAND(0),
    SPEEX_WIDEBAND(1),
    SPEEX_ULTRAWIDEBAND(2),
    CELT_MONO(3);

    private int index;

    Codec(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }
}
