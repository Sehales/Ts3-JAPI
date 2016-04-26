package net.sehales.ts3_japi.command;

import java.util.List;

import net.sehales.ts3_japi.command.parameter.KeyValueParameter;
import net.sehales.ts3_japi.property.ChannelGroupProperty;
import net.sehales.ts3_japi.property.ChannelProperty;
import net.sehales.ts3_japi.property.ClientProperty;
import net.sehales.ts3_japi.wrapper.MapWrapper;

public class CmdChannelGroupClientList extends ArrayResponseCommand {

    public CmdChannelGroupClientList() {
        super("channelgroupclientlist");
    }

    public CmdChannelGroupClientList channelGroupId(int channelGroupId) {
        add(new KeyValueParameter("cgid", channelGroupId));
        return this;
    }

    public CmdChannelGroupClientList channelId(int channelId) {
        add(new KeyValueParameter("cid", channelId));
        return this;
    }

    public CmdChannelGroupClientList clientDbId(int clientDbId) {
        add(new KeyValueParameter("cldbid", clientDbId));
        return this;
    }

    /**
     * This <code>List<{@link MapWrapper}></code> only contains {@link MapWrapper}-objects with the following three entries:
     * {@link ChannelProperty#CID}, {@link ClientProperty#CLDBID} and {@link ChannelGroupProperty#CGID}
     */
    @Override
    public List<MapWrapper> getResponseWrapper() {
        return response.getWrapperList();
    }
}
