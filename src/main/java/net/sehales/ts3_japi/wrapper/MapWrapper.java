package net.sehales.ts3_japi.wrapper;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import net.sehales.ts3_japi.property.Property;

public class MapWrapper implements Wrapper {
    protected Map<String, String> data;

    public MapWrapper(Map<String, String> data) {
        this.data = data;
    }

    /**
     * 
     * @throws NullPointerException
     *             if there is no entry with this key available
     */
    public boolean getBoolean(Property property) {
        return getBoolean(property.toString());
    }

    /**
     * 
     * @throws NullPointerException
     *             if there is no entry with this key available
     */
    public boolean getBoolean(String key) {
        return getInt(key) != 0;
    }

    /**
     * 
     * @throws NullPointerException
     *             if there is no entry with this key available
     */
    public double getDouble(Property property) {
        return getDouble(property.toString());
    }

    /**
     * 
     * @throws NullPointerException
     *             if there is no entry with this key available
     */
    public double getDouble(String key) {
        String str = getString(key);
        Objects.requireNonNull(str, "string may not be null");
        return Double.valueOf(str);
    }

    /**
     * 
     * @throws NullPointerException
     *             if there is no entry with this key available
     */
    public float getFloat(Property property) {
        return getFloat(property.toString());
    }

    /**
     * 
     * 
     * @throws NullPointerException
     *             if there is no entry with this key available
     */
    public float getFloat(String key) {
        String str = getString(key);
        Objects.requireNonNull(str, "string may not be null");
        return Float.valueOf(str);
    }

    /**
     * 
     * 
     * @throws NullPointerException
     *             if there is no entry with this key available
     */
    public int getInt(Property property) {
        return getInt(property.toString());
    }

    /**
     * 
     * 
     * @throws NullPointerException
     *             if there is no entry with this key available
     */
    public int getInt(String key) {
        String str = getString(key);
        Objects.requireNonNull(str, "string may not be null");
        return Integer.valueOf(str);
    }

    /**
     * 
     * 
     * @throws NullPointerException
     *             if there is no entry with this key available
     */
    public long getLong(Property property) {
        return getLong(property.toString());
    }

    /**
     * 
     * @throws NullPointerException
     *             if there is no entry with this key available
     */
    public long getLong(String key) {
        String str = getString(key);
        Objects.requireNonNull(str, "string may not be null");
        return Long.valueOf(str);
    }

    public Optional<Boolean> getOBoolean(Property property) {
        return getOBoolean(property.toString());
    }

    public Optional<Boolean> getOBoolean(String key) {
        Optional<Integer> oi = getOInt(key);
        return oi.map(value -> value != 0);
    }

    public Optional<Double> getODouble(Property property) {
        return getODouble(property.toString());
    }

    public Optional<Double> getODouble(String key) {
        String str = getString(key);
        return Optional.ofNullable(parseDouble(str));
    }

    public Optional<Integer> getOInt(Property property) {
        return getOInt(property.toString());
    }

    public Optional<Integer> getOInt(String key) {
        String str = getString(key);
        return Optional.ofNullable(parseInt(str));
    }

    public Optional<Long> getOLong(Property property) {
        return getOLong(property.toString());
    }

    public Optional<Long> getOLong(String key) {
        String str = getString(key);
        return Optional.ofNullable(parseLong(str));
    }

    public Optional<String> getOString(Property property) {
        return Optional.ofNullable(getString(property));
    }

    public Optional<String> getOString(String key) {
        return Optional.ofNullable(getString(key));
    }

    public String getString(Property property) {
        return getString(property.toString());
    }

    public String getString(String key) {
        Objects.requireNonNull(key, "key may not be null");
        return data.get(key);
    }

    private Double parseDouble(String str) {
        try {
            return Double.valueOf(str);
        } catch (Exception e) {
            return null;
        }
    }

    private Integer parseInt(String str) {
        try {
            return Integer.valueOf(str);
        } catch (Exception e) {
            return null;
        }
    }

    private Long parseLong(String str) {
        try {
            return Long.valueOf(str);
        } catch (Exception e) {
            return null;
        }
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
