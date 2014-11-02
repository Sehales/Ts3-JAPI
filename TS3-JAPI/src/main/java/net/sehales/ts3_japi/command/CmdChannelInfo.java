package net.sehales.ts3_japi.command;

import net.sehales.ts3_japi.command.parameter.KeyValueParameter;

public class CmdChannelInfo extends ArrayResponseCommand {

    public CmdChannelInfo(int cid) {
        super("channelinfo");
        add(new KeyValueParameter("cid", cid));
    }

}
