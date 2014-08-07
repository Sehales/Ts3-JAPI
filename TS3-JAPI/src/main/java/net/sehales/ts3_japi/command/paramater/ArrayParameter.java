package net.sehales.ts3_japi.command.paramater;

import java.util.ArrayList;
import java.util.List;

public class ArrayParameter extends Parameter {
    List<Parameter> params = new ArrayList<>();

    public ArrayParameter(Parameter... parameters) {
        for (Parameter param : parameters) {
            params.add(param);
        }
    }

    public ArrayParameter add(Parameter param) {
        params.add(param);
        return this;
    }

    @Override
    public String buildString() {
        StringBuilder sb = new StringBuilder();
        for (Parameter param : params) {
            sb.append("|");
            sb.append(param.buildString());
        }
        return sb.length() > 0 ? sb.substring(1) : "";
    }

}
