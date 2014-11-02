package net.sehales.ts3_japi.command;

import net.sehales.ts3_japi.command.parameter.KeyValueParameter;

public class CmdFtGetFileInfo extends ArrayResponseCommand {

    public CmdFtGetFileInfo(int channelId, String channelPassword, String filePath) {
        super("ftgetfileinfo");
        add(new KeyValueParameter("cid", channelId));
        add(new KeyValueParameter("cpw", channelPassword));
        add(new KeyValueParameter("name", filePath));
    }

}
