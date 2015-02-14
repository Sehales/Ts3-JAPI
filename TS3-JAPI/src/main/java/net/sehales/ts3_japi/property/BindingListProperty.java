package net.sehales.ts3_japi.property;

public enum BindingListProperty implements Property {
    IP;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
