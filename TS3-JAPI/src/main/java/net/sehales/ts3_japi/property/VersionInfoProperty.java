package net.sehales.ts3_japi.property;

public enum VersionInfoProperty {
    PLATFORM, BUILD, VERSION;

    public String getName() {
        return name().toLowerCase();
    }
}
