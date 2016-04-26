package net.sehales.ts3_japi.command;

import net.sehales.ts3_japi.command.parameter.KeyValueParameter;

public class CmdSetClientChannelGroup extends Command {

    public CmdSetClientChannelGroup(int channelGroupId, int channelId, int clientDbId) {
        super("setclientchannelgroup");
        add(new KeyValueParameter("cgid", channelGroupId));
        add(new KeyValueParameter("cid", channelId));
        add(new KeyValueParameter("cldbid", clientDbId));
    }
}
