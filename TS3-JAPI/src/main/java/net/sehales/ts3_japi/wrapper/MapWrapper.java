package net.sehales.ts3_japi.wrapper;

import java.util.Map;
import java.util.Objects;

import net.sehales.ts3_japi.property.Property;

public class MapWrapper implements Wrapper {
    protected Map<String, String> data;

    @SuppressWarnings("unused")
    private MapWrapper() {}

    public MapWrapper(Map<String, String> data) {
        this.data = data;
    }

    public boolean getBoolean(Property property) {
        return getBoolean(property.toString());
    }

    public boolean getBoolean(String key) {
        return getInt(key) != 0;
    }

    public double getDouble(Property property) {
        return getDouble(property.toString());
    }

    public double getDouble(String key) {
        String str = getString(key);
        Objects.requireNonNull(str, "string may not be null");
        return Double.valueOf(str);
    }

    public float getFloat(Property property) {
        return getFloat(property.toString());
    }

    public float getFloat(String key) {
        String str = getString(key);
        Objects.requireNonNull(str, "string may not be null");
        return Float.valueOf(str);
    }

    public int getInt(Property property) {
        return getInt(property.toString());
    }

    public int getInt(String key) {
        String str = getString(key);
        Objects.requireNonNull(str, "string may not be null");
        return Integer.valueOf(str);
    }

    public long getLong(Property property) {
        return getLong(property.toString());
    }

    public long getLong(String key) {
        String str = getString(key);
        Objects.requireNonNull(str, "string may not be null");
        return Long.valueOf(str);
    }

    public String getString(Property property) {
        return getString(property.toString());
    }

    public String getString(String key) {
        Objects.requireNonNull(key, "key may not be null");
        return data.get(key);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('{');
        for (Map.Entry<String, String> e : data.entrySet()) {
            sb.append(String.format("[%s] = \"%s\", ", e.getKey(), e.getValue()));
        }
        sb.delete(sb.length() - 2, sb.length());
        sb.append('}');
        return sb.toString();
    }
}
