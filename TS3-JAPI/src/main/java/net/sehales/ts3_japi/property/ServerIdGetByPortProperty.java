package net.sehales.ts3_japi.property;

public enum ServerIdGetByPortProperty implements Property {
    SERVER_ID;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
