package net.sehales.ts3_japi.command;

import net.sehales.ts3_japi.command.parameter.KeyValueParameter;
import net.sehales.ts3_japi.util.QueryUtils;

public class CmdChannelDelete extends Command {

    public CmdChannelDelete(int channelId, boolean force) {
        super("channeldelete");
        add(new KeyValueParameter("cid", channelId));
        add(new KeyValueParameter("force", QueryUtils.toInt(force)));
    }

}
