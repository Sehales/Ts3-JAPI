package net.sehales.ts3_japi.command;

import net.sehales.ts3_japi.command.parameter.KeyValueParameter;
import net.sehales.ts3_japi.property.ChannelProperty;
import net.sehales.ts3_japi.wrapper.MapWrapper;

public class CmdChannelInfo extends ArrayResponseCommand {

    public CmdChannelInfo(int cid) {
        super("channelinfo");
        add(new KeyValueParameter("cid", cid));
    }

    /**
     * Take a look at {@link ChannelProperty} for possible properties you can get from this {@link MapWrapper}
     */
    @Override
    public MapWrapper getResponseWrapper() {
        return response.getWrapper();
    }

}
