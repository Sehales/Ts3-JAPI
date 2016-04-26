package net.sehales.ts3_japi.command.response;

public class Response {
    protected String rawResponse;

    public Response(String rawResponse) {
        this.rawResponse = rawResponse;
    }

    public String getRawResponse() {
        return rawResponse;
    }

    @Override
    public String toString() {
        return rawResponse;
    }
}
