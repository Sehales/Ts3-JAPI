package net.sehales.ts3_japi.command;

import net.sehales.ts3_japi.property.ServerInstanceProperty;
import net.sehales.ts3_japi.wrapper.MapWrapper;

public class CmdInstanceInfo extends ArrayResponseCommand {

    public CmdInstanceInfo() {
        super("instanceinfo");
    }

    /**
     * Take a look at {@link ServerInstanceProperty} for possible properties you can get from that {@link MapWrapper}
     */
    public MapWrapper getResponseWrapper() {
        return new MapWrapper(response.getResponseData().get(0));
    }
}
