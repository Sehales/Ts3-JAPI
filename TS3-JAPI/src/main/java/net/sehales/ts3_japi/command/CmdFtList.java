package net.sehales.ts3_japi.command;

import java.util.List;

import net.sehales.ts3_japi.property.ChannelProperty;
import net.sehales.ts3_japi.property.ClientProperty;
import net.sehales.ts3_japi.wrapper.MapWrapper;

public class CmdFtList extends ArrayResponseCommand {

    public CmdFtList() {
        super("ftlist");
    }

    /**
     * @return a <code>List<{@link MapWrapper}></code> with each entry containing entries with the following keys: {@link ClientProperty#CLDBID},
     *         {@link ChannelProperty#CID}
     */
    @Override
    public List<MapWrapper> getResponseWrapper() {
        return response.getWrapperList();
    }

}
