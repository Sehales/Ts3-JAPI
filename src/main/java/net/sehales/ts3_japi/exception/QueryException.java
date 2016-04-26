package net.sehales.ts3_japi.exception;

import net.sehales.ts3_japi.wrapper.QueryError;

public class QueryException extends Exception {

    private QueryError        error;

    private static final long serialVersionUID = -4148723555429917015L;

    public QueryException(QueryError error) {
        this.error = error;
    }

    public QueryError getError() {
        return error;
    }

    @Override
    public String getMessage() {
        return error.getMessage() + " " + error.getExtraMessage();
    }

}
