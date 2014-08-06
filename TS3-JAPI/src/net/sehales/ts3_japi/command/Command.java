package net.sehales.ts3_japi.command;

import net.sehales.ts3_japi.command.response.ArrayResponse;
import net.sehales.ts3_japi.command.response.Response;
import net.sehales.ts3_japi.wrapper.QueryError;

public abstract class Command extends Sendable {
    protected Response response;
    protected String   command;

    private QueryError error;

    @Override
    public String buildString() {
        return command;
    }

    @Override
    public void feedError(String line) {
        error = new QueryError(new ArrayResponse(line.substring(line.indexOf(" "), line.length())).getResponseData().get(0));
    }

    @Override
    public void feedResponse(String line) {
        // TODO override this when implementing the "help" command
        response = new ArrayResponse(line);
    }

    public QueryError getErrorResponse() {
        return error;
    }

    public Response getResponse() {
        return response;
    }
}
