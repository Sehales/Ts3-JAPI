package net.sehales.ts3_japi.command;

import net.sehales.ts3_japi.command.parameter.OptionParameter;

public class CmdChannelGroupPermList extends Command {

    public CmdChannelGroupPermList() {
        super("channelgrouppermlist");
    }

    public CmdChannelGroupPermList permsId() {
        add(new OptionParameter("permsid"));
        return this;
    }

}
