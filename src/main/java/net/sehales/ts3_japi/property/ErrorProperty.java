package net.sehales.ts3_japi.property;

public enum ErrorProperty implements Property {
    MSG, ID, EXTRA_MSG;
    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
