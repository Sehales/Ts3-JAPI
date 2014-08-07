package net.sehales.ts3_japi.command.paramater;

import net.sehales.ts3_japi.StringUtils;

public class ValueParameter extends Parameter {

    private String value;

    @SuppressWarnings("unused")
    private ValueParameter() {}

    public ValueParameter(String value) {
        this.value = value;
    }

    @Override
    public String buildString() {
        return StringUtils.encode(value);
    }

}
