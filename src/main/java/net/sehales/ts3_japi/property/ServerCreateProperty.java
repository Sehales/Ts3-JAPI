package net.sehales.ts3_japi.property;

public enum ServerCreateProperty implements Property {
    SID, VIRTUALSERVER_PORT, TOKEN;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
