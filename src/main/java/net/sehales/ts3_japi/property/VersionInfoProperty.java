package net.sehales.ts3_japi.property;

public enum VersionInfoProperty implements Property {
    BUILD, PLATFORM, VERSION;

    @Override
    public String toString() {
        return name().toLowerCase();
    }

}
