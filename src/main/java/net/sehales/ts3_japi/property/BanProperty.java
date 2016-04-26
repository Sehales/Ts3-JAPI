package net.sehales.ts3_japi.property;

public enum BanProperty implements Property {
    DURATION,
    UID,
    INVOKERCLDBID,
    ENFORCEMENTS,
    REASON,
    INVOKERNAME,
    LASTNICKNAME,
    CREATED,
    INVOKERUID,
    IP,
    BANID;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
