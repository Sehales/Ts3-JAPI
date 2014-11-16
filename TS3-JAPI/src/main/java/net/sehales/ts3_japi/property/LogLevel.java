package net.sehales.ts3_japi.property;

public enum LogLevel implements Property {
    ERROR(1),
    WARNING(2),
    DEBUG(3),
    INFO(4);

    private int index;

    LogLevel(int index) {
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
