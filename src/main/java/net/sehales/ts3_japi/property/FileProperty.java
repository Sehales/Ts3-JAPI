package net.sehales.ts3_japi.property;

public enum FileProperty implements Property {
    SIZE,
    DATETIME,
    TYPE,
    NAME,
    /**
     * returned instead of {@link #SIZE} when a file isn't completely uploaded, but returns the final file size rather the incomplete file size...
     */
    INCOMPLETESIZE;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
