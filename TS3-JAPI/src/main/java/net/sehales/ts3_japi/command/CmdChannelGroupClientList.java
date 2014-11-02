package net.sehales.ts3_japi.command;

import net.sehales.ts3_japi.command.parameter.KeyValueParameter;

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
}
