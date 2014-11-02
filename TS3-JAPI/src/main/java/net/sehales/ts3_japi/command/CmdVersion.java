package net.sehales.ts3_japi.command;

import net.sehales.ts3_japi.property.VersionInfoProperty;
import net.sehales.ts3_japi.wrapper.MapWrapper;

public class CmdVersion extends ArrayResponseCommand {

    public CmdVersion() {
        super("version");
    }

    /**
     * Take a look at {@link VersionInfoProperty} for possible properties you can get from that {@link MapWrapper}
     */
    public MapWrapper getResponseWrapper() {
        return new MapWrapper(response.getResponseData().get(0));
    }

}
