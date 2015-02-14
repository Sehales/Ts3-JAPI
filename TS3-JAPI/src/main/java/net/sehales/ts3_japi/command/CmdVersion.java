package net.sehales.ts3_japi.command;

import net.sehales.ts3_japi.property.VersionInfoProperty;
import net.sehales.ts3_japi.wrapper.MapWrapper;

public class CmdVersion extends ArrayResponseCommand {

    public CmdVersion() {
        super("version");
    }

    /**
     * Take a look at {@link VersionInfoProperty} for possible properties you can get from this {@link MapWrapper}
     */
    @Override
    public MapWrapper getResponseWrapper() {
        return response.getWrapper();
    }

}
