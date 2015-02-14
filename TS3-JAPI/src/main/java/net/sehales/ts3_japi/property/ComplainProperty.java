package net.sehales.ts3_japi.property;

public enum ComplainProperty implements Property {
    TCLDBID,
    TNAME,
    FCLDBID,
    FNAME,
    TIMESTAMP;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
