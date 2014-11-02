package net.sehales.ts3_japi.command;

import net.sehales.ts3_japi.command.parameter.OptionParameter;

public class CmdChannelList extends ArrayResponseCommand {

    public CmdChannelList() {
        super("channellist");
    }

    public CmdChannelList flags() {
        add(new OptionParameter("flags"));
        return this;
    }

    public CmdChannelList icon() {
        add(new OptionParameter("icon"));
        return this;
    }

    public CmdChannelList limits() {
        add(new OptionParameter("limits"));
        return this;
    }

    public CmdChannelList topic() {
        add(new OptionParameter("topic"));
        return this;
    }

    public CmdChannelList voice() {
        add(new OptionParameter("voice"));
        return this;
    }

}
