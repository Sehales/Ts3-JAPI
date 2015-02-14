package net.sehales.ts3_japi.property;

public enum MessageProperty implements Property {
    MSGID,
    CLUID,
    SUBJECT,
    FLAG_READ,
    TIMESTAMP,
    MESSAGE;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
