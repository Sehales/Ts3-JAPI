package net.sehales.ts3_japi.command.parameter;

import java.util.ArrayList;
import java.util.List;

public class ListParameter extends Parameter {
    private List<Parameter> params = new ArrayList<>();

    public ListParameter(Parameter... params) {
        for (Parameter param : params) {
            add(param);
        }
    }

    public void add(Parameter param) {
        params.add(param);
    }

    @Override
    public String buildString() {
        StringBuilder sb = new StringBuilder();
        for (Parameter param : params) {
            sb.append(" ").append(param.buildString());
        }
        return sb.length() > 1 ? sb.substring(1) : "";
    }

}
