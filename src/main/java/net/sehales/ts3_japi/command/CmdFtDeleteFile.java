package net.sehales.ts3_japi.command;

import net.sehales.ts3_japi.command.parameter.KeyValueParameter;

public class CmdFtDeleteFile extends Command {

    public CmdFtDeleteFile(int channelId, String channelPassword, String filePath) {
        super("ftdeletefile");
        add(new KeyValueParameter("cid", channelId));
        add(new KeyValueParameter("cpw", channelPassword));
        add(new KeyValueParameter("name", filePath));
    }

}
