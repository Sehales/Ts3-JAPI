package net.sehales.ts3_japi.command;

import net.sehales.ts3_japi.command.parameter.KeyValueParameter;
import net.sehales.ts3_japi.property.GroupDbType;

public class CmdChannelGroupAdd extends Command {
    public CmdChannelGroupAdd(String name) {
        super("channelgroupadd");
        add(new KeyValueParameter("name", name));
    }

    public CmdChannelGroupAdd(String name, GroupDbType type) {
        this(name);
        add(new KeyValueParameter("type", type.getIndex()));
    }
}
