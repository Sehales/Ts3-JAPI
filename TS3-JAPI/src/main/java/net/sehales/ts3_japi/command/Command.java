package net.sehales.ts3_japi.command;

import net.sehales.ts3_japi.Sendable;
import net.sehales.ts3_japi.command.parameter.ListParameter;
import net.sehales.ts3_japi.command.parameter.Parameter;
import net.sehales.ts3_japi.command.response.ArrayResponse;
import net.sehales.ts3_japi.command.response.Response;
import net.sehales.ts3_japi.wrapper.QueryError;

public abstract class Command extends Sendable {
    protected ListParameter params = new ListParameter();
    protected String        command;
    protected Response      response;
    protected String        error;

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
        sb.append(" ");
        sb.append(params.buildString());
        return sb.toString();
    }

    @Override
    public void feedError(String line) {
        error = line;
    }

    @Override
    public void feedResponse(String line) {
        response = new Response(line);
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

    public boolean hasResponse() {
        return response != null;
    }
}
