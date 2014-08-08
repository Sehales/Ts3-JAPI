package net.sehales.ts3_japi.command.parameter;

public class RawParameter extends Parameter {
    private String value;

    public RawParameter(String value) {
        this.value = value;
    }

    @Override
    public String buildString() {
        return value;
    }

}
