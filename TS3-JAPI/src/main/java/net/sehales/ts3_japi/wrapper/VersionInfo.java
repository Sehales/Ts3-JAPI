package net.sehales.ts3_japi.wrapper;

import java.util.Map;

import net.sehales.ts3_japi.property.VersionInfoProperty;

public class VersionInfo extends MapWrapper {

    public VersionInfo(Map<String, String> map) {
        super(map);
    }

    public String getBuild() {
        return getString(VersionInfoProperty.BUILD.getName());
    }

    public String getPlatform() {
        return getString(VersionInfoProperty.PLATFORM.getName());
    }

    public String getVersion() {
        return getString(VersionInfoProperty.VERSION.getName());
    }

}
