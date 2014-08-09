package net.sehales.ts3_japi.command;

import net.sehales.ts3_japi.command.response.ArrayResponse;
import net.sehales.ts3_japi.wrapper.MapWrapper;

public class CmdBindingList extends Command {

    public CmdBindingList() {
        super("bindinglist");
    }

    /**
     * the only key this map has is {@code id}
     */
    public MapWrapper getResponseWrapper() {
        return new MapWrapper(((ArrayResponse) response).getResponseData().get(0));
    }

}
