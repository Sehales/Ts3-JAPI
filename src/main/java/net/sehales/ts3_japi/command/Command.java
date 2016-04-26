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
    protected QueryError    error;
    protected String        fullCommand;

    public Command(String command) {
        this.command = command;
    }

    protected Command add(Parameter param) {
        params.add(param);
        return this;
    }

    /**
     * builds the actual command string (concatenates the command with its parameters)
     * 
     * </br>once called the string will be saved and only the saved string will be returned
     */
    @Override
    public String buildString() {
        if (fullCommand == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(command);
            sb.append(" ");
            sb.append(params.buildString());
            fullCommand = sb.toString();
        }
        return fullCommand;
    }

    @Override
    public void feedError(String line) {
        error = new QueryError(new ArrayResponse(line).getMap());
    }

    @Override
    public void feedResponse(String line) {
        response = new Response(line);
    }

    public QueryError getError() {
        return error;
    }

    public Response getResponse() {
        return response;
    }

    public boolean hasResponse() {
        return response != null;
    }
}
