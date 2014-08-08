package net.sehales.ts3_japi.wrapper;

import net.sehales.ts3_japi.command.response.AppendableResponse;

public abstract class HelpWrapper implements Wrapper {

    public HelpWrapper(AppendableResponse response) {
        parseResponse(response);
    }

    protected abstract void parseResponse(AppendableResponse response);

}
