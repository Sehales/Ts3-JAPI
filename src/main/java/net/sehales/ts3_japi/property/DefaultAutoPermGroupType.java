package net.sehales.ts3_japi.property;

public enum DefaultAutoPermGroupType implements Property {
    CHANNEL_GUEST(10),
    SERVER_GUEST(15),
    QUERY_GUEST(20),
    CHANNEL_VOICE(25),
    SERVER_NORMAL(30),
    CHANNEL_OPERATOR(35),
    CHANNEL_ADMIN(40),
    SERVER_ADMIN(45),
    QUERY_ADMIN(50);

    private int index;

    DefaultAutoPermGroupType(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
