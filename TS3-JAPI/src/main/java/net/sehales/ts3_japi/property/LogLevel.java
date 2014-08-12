package net.sehales.ts3_japi.property;

public enum LogLevel {
    LogLevel_ERROR(1),
    LogLevel_WARNING(2),
    LogLevel_DEBUG(3),
    LogLevel_INFO(4);

    private int index;

    LogLevel(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }
}
