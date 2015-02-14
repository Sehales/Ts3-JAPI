package net.sehales.ts3_japi.property;

public enum ServerListProperty implements Property {
    VIRTUALSERVER_ID,
    VIRTUALSERVER_QUERYCLIENTSONLINE,
    VIRTUALSERVER_STATUS,
    VIRTUALSERVER_UPTIME,
    VIRTUALSERVER_PORT,
    VIRTUALSERVER_MAXCLIENTS,
    VIRTUALSERVER_AUTOSTART,
    VIRTUALSERVER_UNIQUE_IDENTIFIER,
    VIRTUALSERVER_NAME,
    VIRTUALSERVER_CLIENTSONLINE;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
