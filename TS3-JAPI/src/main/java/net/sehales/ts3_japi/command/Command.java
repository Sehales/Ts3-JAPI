package net.sehales.ts3_japi.command;

import java.util.ArrayList;
import java.util.List;

import net.sehales.ts3_japi.command.parameter.Parameter;
import net.sehales.ts3_japi.command.response.ArrayResponse;
import net.sehales.ts3_japi.command.response.Response;
import net.sehales.ts3_japi.wrapper.QueryError;
import net.sehales.ts3_japi.wrapper.Wrapper;

public abstract class Command extends Sendable {
    protected List<Parameter> params = new ArrayList<>();
    protected String          command;
    protected Response        response;
    protected String          error;

    public Command(String command) {
        this.command = command;
    }

    protected Command add(Parameter param) {
        params.add(param);
        return this;
    }

    @Override
    public String buildString() {
        StringBuilder sb = new StringBuilder();
        sb.append(command);
        for (Parameter param : params) {
            sb.append(" ").append(param.buildString());
        }
        return sb.toString();
    }

    @Override
    public void feedError(String line) {
        error = line;
    }

    @Override
    public void feedResponse(String line) {
        if (!line.isEmpty()) {
            response = new ArrayResponse(line);
        }
    }

    public QueryError getError() {
        return new QueryError(new ArrayResponse(error).getResponseData().get(0));
    }

    public String getErrorResponse() {
        return error;
    }

    public Response getResponse() {
        return response;
    }

    public abstract Wrapper getResponseWrapper();

    public boolean hasResponse() {
        return response != null;
    }
}
