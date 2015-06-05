package net.sehales.ts3_japi.property;

import java.util.HashMap;
import java.util.Map;

public enum HostMessageMode implements Property {
    NONE(0),
    LOG(1),
    MODAL(2),
    MODALQUIT(3);

    private static Map<Integer, HostMessageMode> map = new HashMap<>();

    static {
        for (HostMessageMode m : values()) {
            map.put(m.getIndex(), m);
        }
    }

    public static HostMessageMode getByIndex(int i) {
        return map.get(i);
    }

    private int index;

    private HostMessageMode(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }
}
