package net.sehales.ts3_japi.property;

public enum ClientProperty {
    CLIENT_UNIQUE_IDENTIFIER(false),
    CLIENT_NICKNAME(true),
    CLIENT_VERSION(false),
    CLIENT_PLATFORM(false),
    CLIENT_INPUT_MUTED(false),
    CLIENT_OUTPUT_MUTED(false),
    CLIENT_INPUT_HARDWARE(false),
    CLIENT_OUTPUT_HARDWARE(false),
    CLIENT_DEFAULT_CHANNEL(false),
    CLIENT_LOGIN_NAME(false),
    CLIENT_DATABASE_ID(false),
    CLIENT_CHANNEL_GROUP_ID(false),
    CLIENT_SERVER_GROUPS(false),
    CLIENT_CREATED(false),
    CLIENT_LASTCONNECTED(false),
    CLIENT_TOTALCONNECTIONS(false),
    CLIENT_AWAY(false),
    CLIENT_AWAY_MESSAGE(false),
    CLIENT_TYPE(false),
    CLIENT_FLAG_AVATAR(false),
    CLIENT_TALK_POWER(false),
    CLIENT_TALK_REQUEST(false),
    CLIENT_TALK_REQUEST_MSG(false),
    CLIENT_IS_TALKER(true),
    CLIENT_MONTH_BYTES_DOWNLOADED(false),
    CLIENT_MONTH_BYTES_UPLOADED(false),
    CLIENT_TOTAL_BYTES_DOWNLOADED(false),
    CLIENT_TOTAL_BYTES_UPLOADED(false),
    CLIENT_IS_PRIORITY_SPEAKER(false),
    CLIENT_UNREAD_MESSAGES(false),
    CLIENT_NICKNAME_PHONETIC(false),
    CLIENT_DESCRIPTION(true),
    CLIENT_NEEDED_SERVERQUERY_VIEW_POWER(false),
    CONNECTION_FILETRANSFER_BANDWIDTH_SENT(false),
    CONNECTION_FILETRANSFER_BANDWIDTH_RECEIVED(false),
    CONNECTION_PACKETS_SENT_TOTAL(false),
    CONNECTION_PACKETS_RECEIVED_TOTAL(false),
    CONNECTION_BYTES_SENT_TOTAL(false),
    CONNECTION_BYTES_RECEIVED_TOTAL(false),
    CONNECTION_BANDWIDTH_SENT_LAST_SECOND_TOTAL(false),
    CONNECTION_BANDWIDTH_RECEIVED_LAST_SECOND_TOTAL(false),
    CONNECTION_BANDWIDTH_SENT_LAST_MINUTE_TOTAL(false),
    CONNECTION_BANDWIDTH_RECEIVED_LAST_MINUTE_TOTAL(false),
    CONNECTION_CLIENT_IP(false),
    CLIENT_IS_CHANNEL_COMMANDER(true),
    CLIENT_ICON_ID(true),
    CLIENT_COUNTRY(false);

    private boolean changeable;

    ClientProperty(boolean changeable) {
        this.changeable = changeable;
    }

    public String getName() {
        return name().toLowerCase();
    }

    public boolean isChangeable() {
        return changeable;
    }
}
