package net.sehales.ts3_japi.property;

public enum CustomProperty implements Property {
    IDENT,
    VALUE;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
