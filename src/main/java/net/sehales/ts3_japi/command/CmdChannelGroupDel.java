package net.sehales.ts3_japi.command;

import net.sehales.ts3_japi.command.parameter.KeyValueParameter;
import net.sehales.ts3_japi.util.QueryUtils;

public class CmdChannelGroupDel extends Command {

    public CmdChannelGroupDel(int channelGroupId, boolean force) {
        super("channelgroupdel");
        add(new KeyValueParameter("cgid", channelGroupId));
        add(new KeyValueParameter("force", QueryUtils.toInt(force)));
    }

}
