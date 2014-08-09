package net.sehales.ts3_japi.property;

public enum ServerGroupDbType {
    Template(0),
    Regular(1),
    Query(2);
    private int index;

    private ServerGroupDbType(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }
}
