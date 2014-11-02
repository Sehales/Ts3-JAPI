package net.sehales.ts3_japi.command;

import net.sehales.ts3_japi.command.parameter.KeyValueParameter;

public class CmdChannelFind extends ArrayResponseCommand {

    public CmdChannelFind(String pattern) {
        super("channelfind");
        add(new KeyValueParameter("pattern", pattern));
    }

}
