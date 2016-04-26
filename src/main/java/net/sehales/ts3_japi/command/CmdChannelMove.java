package net.sehales.ts3_japi.command;

import net.sehales.ts3_japi.command.parameter.KeyValueParameter;

public class CmdChannelMove extends Command {

    public CmdChannelMove(int channelId, int channelParentId) {
        super("channelmove");
        add(new KeyValueParameter("cid", channelId));
        add(new KeyValueParameter("cpid", channelParentId));
    }

    public CmdChannelMove(int channelId, int channelParentId, int order) {
        this(channelId, channelParentId);
        add(new KeyValueParameter("order", order));
    }

}
