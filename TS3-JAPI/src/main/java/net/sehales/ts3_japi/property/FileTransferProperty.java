package net.sehales.ts3_japi.property;

public enum FileTransferProperty {
    PATH,
    NAME,
    SIZE,
    SIZEDONE,
    CLIENTFTFID,
    SERVERFTFID,
    /**
     * todo: find out what this is needed for
     */
    SENDER,
    /**
     * maybe 1 is running, 0 is paused
     */
    STATUS,
    /**
     * self explaining double value
     */
    CURRENT_SPEED,
    /**
     * self explaining double value
     */
    AVERAGE_SPEED,
    /**
     * time in milliseconds?
     */
    RUNTIME;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
