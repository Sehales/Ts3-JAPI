package net.sehales.ts3_japi.command;

import java.util.List;

import net.sehales.ts3_japi.property.GroupProperty;
import net.sehales.ts3_japi.wrapper.MapWrapper;

public class CmdChannelGroupList extends ArrayResponseCommand {

    public CmdChannelGroupList() {
        super("channelgrouplist");
    }

    /**
     * Take a look at {@link GroupProperty} for possible properties (except {@link GroupProperty#SGID}) you can get from this
     * <code>List<{@link MapWrapper}></code>
     */
    @Override
    public List<MapWrapper> getResponseWrapper() {
        return response.getWrapperList();
    }

}
