package net.sehales.ts3_japi.command;

import java.util.List;

import net.sehales.ts3_japi.command.parameter.KeyValueParameter;
import net.sehales.ts3_japi.property.PermissionInfoProperty;
import net.sehales.ts3_japi.wrapper.MapWrapper;

public class CmdPermOverview extends ArrayResponseCommand {

    private CmdPermOverview(int channelId, int clientDbId) {
        super("permoverview");
        add(new KeyValueParameter("cid", channelId));
        add(new KeyValueParameter("cldbid", clientDbId));
    }

    public CmdPermOverview(int channelId, int clientDbId, int permId) {
        this(channelId, clientDbId);
        add(new KeyValueParameter("permid", permId));
    }

    public CmdPermOverview(int channelId, int clientDbId, String permsId) {
        this(channelId, clientDbId);
        add(new KeyValueParameter("permsid", permsId));
    }

    /**
     * Take a look at {@link PermissionInfoProperty} for the meaning of the entries you can get from this <code>List<{@link MapWrapper}></code>
     */
    @Override
    public List<MapWrapper> getResponseWrapper() {
        return response.getWrapperList();
    }

}
