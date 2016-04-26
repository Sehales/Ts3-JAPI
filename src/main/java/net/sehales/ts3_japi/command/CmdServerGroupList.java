package net.sehales.ts3_japi.command;

import java.util.List;

import net.sehales.ts3_japi.property.GroupProperty;
import net.sehales.ts3_japi.wrapper.MapWrapper;

public class CmdServerGroupList extends ArrayResponseCommand {

    public CmdServerGroupList() {
        super("servergrouplist");
    }

    /**
     * Take a look at {@link GroupProperty} for possible properties (except {@link GroupProperty#CGID}) you can get from this {@link MapWrapper}
     */
    @Override
    public List<MapWrapper> getResponseWrapper() {
        return response.getWrapperList();
    }

}
