package net.sehales.ts3_japi.command.parameter;

import net.sehales.ts3_japi.StringUtils;

public class KeyValueParameter extends Parameter {

    private String key, value;

    public KeyValueParameter(String key, String value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String buildString() {
        return StringUtils.encode(key) + "=" + StringUtils.encode(value);
    }

}
