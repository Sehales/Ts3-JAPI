package net.sehales.ts3_japi.property;

public enum ServerInstanceProperty {
    INSTANCE_UPTIME(false),
    HOST_TIMESTAMP_UTC(false),
    VIRTUALSERVERS_RUNNING_TOTAL(false),
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
    SERVERINSTANCE_DATABASE_VERSION(false),
    SERVERINSTANCE_GUEST_SERVERQUERY_GROUP(true),
    SERVERINSTANCE_TEMPLATE_SERVERADMIN_GROUP(true),
    SERVERINSTANCE_FILETRANSFER_PORT(true),
    SERVERINSTANCE_MAX_DOWNLOAD_TOTAL_BANDWITDH(true),
    SERVERINSTANCE_MAX_UPLOAD_TOTAL_BANDWITDH(true),
    SERVERINSTANCE_TEMPLATE_SERVERDEFAULT_GROUP(true),
    SERVERINSTANCE_TEMPLATE_CHANNELDEFAULT_GROUP(true),
    SERVERINSTANCE_TEMPLATE_CHANNELADMIN_GROUP(true),
    VIRTUALSERVERS_TOTAL_MAXCLIENTS(false),
    VIRTUALSERVERS_TOTAL_CLIENTS_ONLINE(false),
    VIRTUALSERVERS_TOTAL_CHANNELS_ONLINE(false),
    SERVERINSTANCE_SERVERQUERY_FLOOD_COMMANDS(true),
    SERVERINSTANCE_SERVERQUERY_FLOOD_TIME(true),
    SERVERINSTANCE_SERVERQUERY_FLOOD_BAN_TIME(true);

    private boolean changeable;

    ServerInstanceProperty(boolean changeable) {
        this.changeable = changeable;
    }

    public String getName() {
        return name().toLowerCase();
    }

    public boolean isChangeable() {
        return changeable;
    }
}
