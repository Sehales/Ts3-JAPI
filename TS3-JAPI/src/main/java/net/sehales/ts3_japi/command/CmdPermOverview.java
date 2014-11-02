package net.sehales.ts3_japi.command;

import net.sehales.ts3_japi.command.parameter.KeyValueParameter;

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

}
