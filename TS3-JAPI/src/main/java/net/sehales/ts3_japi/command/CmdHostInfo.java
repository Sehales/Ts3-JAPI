package net.sehales.ts3_japi.command;

import net.sehales.ts3_japi.property.ServerInstanceProperty;
import net.sehales.ts3_japi.wrapper.MapWrapper;

public class CmdHostInfo extends ArrayResponseCommand {

    public CmdHostInfo() {
        super("hostinfo");
    }

    /**
     * Take a look at {@link ServerInstanceProperty} for possible properties you can get from this {@link MapWrapper}
     */
    @Override
    public MapWrapper getResponseWrapper() {
        return response.getWrapper();
    }

}
