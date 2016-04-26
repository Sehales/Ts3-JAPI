package net.sehales.ts3_japi.command;

import net.sehales.ts3_japi.command.parameter.KeyValueParameter;

public class CmdChannelGroupRename extends Command {

    public CmdChannelGroupRename(int channelGroupId, String newName) {
        super("channelgrouprename");
        add(new KeyValueParameter("cgid", channelGroupId));
        add(new KeyValueParameter("name", newName));
    }

}
