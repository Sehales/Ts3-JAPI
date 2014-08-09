package net.sehales.ts3_japi.command.response;

import java.util.ArrayList;
import java.util.List;

public class AppendableResponse extends Response {

    private List<String> lines = new ArrayList<>();

    public AppendableResponse() {
        super("");
    }

    public void append(String nextResponse) {
        rawResponse += (nextResponse + "\n");
        lines.add(nextResponse);
    }

    public List<String> getLines() {
        return lines;
    }

}
