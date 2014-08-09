package net.sehales.ts3_japi.property;

public enum ChannelProperty {
    CHANNEL_CODEC(true),
    CHANNEL_CODEC_IS_UNENCRYPTED(true),
    CHANNEL_CODEC_QUALITY(true),
    CHANNEL_DESCRIPTION(true),
    CHANNEL_FILEPATH(false),
    CHANNEL_FLAG_DEFAULT(true),
    CHANNEL_FLAG_MAXCLIENTS_UNLIMITED(true),
    CHANNEL_FLAG_MAXFAMILYCLIENTS_INHERITED(true),
    CHANNEL_FLAG_MAXFAMILYCLIENTS_UNLIMITED(true),
    CHANNEL_FLAG_PASSWORD(false),
    CHANNEL_FLAG_PERMANENT(true),
    CHANNEL_FLAG_SEMI_PERMANENT(true),
    CHANNEL_FLAG_TEMPORARY(true),
    CHANNEL_FORCED_SILENCE(false),
    CHANNEL_ICON_ID(true),
    CHANNEL_MAXCLIENTS(true),
    CHANNEL_MAXFAMILYCLIENTS(true),
    CHANNEL_NAME(true),
    CHANNEL_NAME_PHONETIC(true),
    CHANNEL_NEEDED_TALK_POWER(true),
    CHANNEL_ORDER(true),
    CHANNEL_PASSWORD(true),
    CHANNEL_TOPIC(true),
    CID(false),
    CPID(true);

    private boolean changeable;

    ChannelProperty(boolean changeable) {
        this.changeable = changeable;
    }

    public String getName() {
        return name().toLowerCase();
    }

    public boolean isChangeable() {
        return changeable;
    }
}
