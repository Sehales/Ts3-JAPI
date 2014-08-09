package net.sehales.ts3_japi.property;

public enum VersionInfoProperty {
    BUILD, PLATFORM, VERSION;

    public String getName() {
        return name().toLowerCase();
    }
}
