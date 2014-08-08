package net.sehales.ts3_japi.command.parameter;

public class OptionParameter extends Parameter {
    private String option;

    public OptionParameter(String option) {
        this.option = option;
    }

    @Override
    public String buildString() {
        return "-" + option;
    }

}
