package net.sehales.ts3_japi.command;

import net.sehales.ts3_japi.property.VirtualServerProperty;
import net.sehales.ts3_japi.wrapper.MapWrapper;

public class CmdServerInfo extends ArrayResponseCommand {

    public CmdServerInfo() {
        super("serverinfo");
    }

    /**
     * Take a look at {@link VirtualServerProperty} for possible properties you can get from this {@link MapWrapper}
     */
    @Override
    public MapWrapper getResponseWrapper() {
        return response.getWrapper();
    }

}
