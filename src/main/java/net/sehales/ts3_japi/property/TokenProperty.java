package net.sehales.ts3_japi.property;

public enum TokenProperty implements Property {
    TOKEN,
    TOKEN_TYPE,
    TOKEN_ID1,
    TOKEN_ID2,
    TOKEN_CREATED,
    TOKEN_DESCRIPTION;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
