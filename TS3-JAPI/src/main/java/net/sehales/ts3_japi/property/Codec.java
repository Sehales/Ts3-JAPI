package net.sehales.ts3_japi.property;

public enum Codec {
    CODEC_SPEEX_NARROWBAND(0),
    CODEC_SPEEX_WIDEBAND(1),
    CODEC_SPEEX_ULTRAWIDEBAND(2),
    CODEC_CELT_MONO(3);

    private int index;

    Codec(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }
}
