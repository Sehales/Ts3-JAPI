package net.sehales.ts3_japi.command;

import net.sehales.ts3_japi.command.parameter.KeyValueParameter;

public class CmdFtGetFileList extends ArrayResponseCommand {

    public CmdFtGetFileList(int channelId, String channelPassword, String filePath) {
        super("ftgetfilelist");
        add(new KeyValueParameter("cid", channelId));
        add(new KeyValueParameter("cpw", channelPassword));
        add(new KeyValueParameter("name", filePath));
    }

}
