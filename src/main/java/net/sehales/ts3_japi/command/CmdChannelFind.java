package net.sehales.ts3_japi.command;

import java.util.List;

import net.sehales.ts3_japi.command.parameter.KeyValueParameter;
import net.sehales.ts3_japi.property.ChannelProperty;
import net.sehales.ts3_japi.wrapper.MapWrapper;

public class CmdChannelFind extends ArrayResponseCommand {

    public CmdChannelFind(String pattern) {
        super("channelfind");
        add(new KeyValueParameter("pattern", pattern));
    }

    /**
     * This <code>List<{@link MapWrapper}></code> only contains {@link MapWrapper}-objects with the following two entries: {@link ChannelProperty#CID}
     * and {@link ChannelProperty#CHANNEL_NAME}
     */
    @Override
    public List<MapWrapper> getResponseWrapper() {
        return response.getWrapperList();
    }

}
