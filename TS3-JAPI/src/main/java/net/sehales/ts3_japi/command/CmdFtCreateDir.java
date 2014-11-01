package net.sehales.ts3_japi.command;

import net.sehales.ts3_japi.command.parameter.KeyValueParameter;

public class CmdFtCreateDir extends Command {

    public CmdFtCreateDir(int channelId, String channelPassword, String directoryPath) {
        super("ftcreatedir");
        add(new KeyValueParameter("cid", channelId));
        add(new KeyValueParameter("cpw", channelPassword));
        add(new KeyValueParameter("dirname", directoryPath));
    }

}
