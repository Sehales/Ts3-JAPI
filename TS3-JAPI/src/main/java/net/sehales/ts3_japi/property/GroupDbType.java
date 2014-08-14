package net.sehales.ts3_japi.property;

public enum GroupDbType {
    TEMPLATE(0),
    REGULAR(1),
    QUERY(2);
    private int index;

    private GroupDbType(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }
}
