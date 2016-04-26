package net.sehales.ts3_japi.property;

public enum GroupDbType implements Property {
    TEMPLATE(0),
    REGULAR(1),
    QUERY(2);
    private int index;

    GroupDbType(int index) {
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
