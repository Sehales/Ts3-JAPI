package net.sehales.ts3_japi.command;

import net.sehales.ts3_japi.command.parameter.KeyValueParameter;
import net.sehales.ts3_japi.command.parameter.OptionParameter;

public class CmdChannelClientPermList extends ArrayResponseCommand {

    public CmdChannelClientPermList(int channelId, int clientDbId) {
        super("channelclientpermlist");
        add(new KeyValueParameter("cid", channelId));
        add(new KeyValueParameter("cldbid", clientDbId));
    }

    public CmdChannelClientPermList permsid() {
        add(new OptionParameter("permsid"));
        return this;
    }
}
