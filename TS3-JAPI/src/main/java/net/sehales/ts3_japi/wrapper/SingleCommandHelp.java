package net.sehales.ts3_japi.wrapper;

import net.sehales.ts3_japi.command.response.AppendableResponse;

public class SingleCommandHelp implements HelpWrapper {

    public SingleCommandHelp(AppendableResponse response) {
        parseResponse(response);
    }

    protected void parseResponse(AppendableResponse response) {
        System.out.print(response);
        // will implement that later...
        // the parsing seems to get horrible annoying
    }

}
