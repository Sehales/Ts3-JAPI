package net.sehales.ts3_japi.wrapper;

import java.util.Map;
import java.util.Objects;

public class Wrapper {
    private Map<String, String> data;

    @SuppressWarnings("unused")
    private Wrapper() {}

    public Wrapper(Map<String, String> data) {
        this.data = data;
    }

    public boolean getBoolean(String key) {
        return getInt(key) == 0;
    }

    public double getDouble(String key) {
        String str = getString(key);
        Objects.requireNonNull(str, "String may not be null");
        return Double.valueOf(str);
    }

    public float getFloat(String key) {
        String str = getString(key);
        Objects.requireNonNull(str, "String may not be null");
        return Float.valueOf(str);
    }

    public int getInt(String key) {
        String str = getString(key);
        Objects.requireNonNull(str, "String may not be null");
        return Integer.valueOf(str);
    }

    public long getLong(String key) {
        String str = getString(key);
        Objects.requireNonNull(str, "String may not be null");
        return Long.valueOf(str);
    }

    public String getString(String key) {
        Objects.requireNonNull(key, "key may not be null");
        return data.get(key);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (Map.Entry<String, String> e : data.entrySet()) {
            sb.append(String.format("[%s] = \"%s\", ", e.getKey(), e.getValue()));
        }

        return sb.substring(0, sb.length() - 2);
    }
}
