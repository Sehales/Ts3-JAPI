package net.sehales.ts3_japi.command;

import net.sehales.ts3_japi.command.parameter.KeyValueParameter;
import net.sehales.ts3_japi.command.parameter.OptionParameter;

public class CmdChannelPermList extends ArrayResponseCommand {

    public CmdChannelPermList(int channelId) {
        super("channelpermlist");
        add(new KeyValueParameter("cid", channelId));
    }

    public CmdChannelPermList permsid() {
        add(new OptionParameter("permsid"));
        return this;
    }
}
