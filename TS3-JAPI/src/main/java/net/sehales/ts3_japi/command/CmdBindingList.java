package net.sehales.ts3_japi.command;

import net.sehales.ts3_japi.wrapper.MapWrapper;

public class CmdBindingList extends ArrayResponseCommand {

    public CmdBindingList() {
        super("bindinglist");
    }

    /**
     * the only key this map has is {@code id}
     */
    public MapWrapper getResponseWrapper() {
        return new MapWrapper(response.getResponseData().get(0));
    }

}
