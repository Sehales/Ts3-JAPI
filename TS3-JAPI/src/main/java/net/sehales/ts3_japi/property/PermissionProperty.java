package net.sehales.ts3_japi.property;

public enum PermissionProperty implements Property {
    PERMID, PERMSID, PERMVALUE, PERMNEGATED, PERMSKIP;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
