package net.sehales.ts3_japi.command;

import net.sehales.ts3_japi.command.parameter.KeyValueParameter;

public class CmdFtInitDownload extends ArrayResponseCommand {

    public CmdFtInitDownload(int clientFileTransferId, String filePath, int channelId, String channelPassword, long seekPos) {
        super("ftinitdownload");
        add(new KeyValueParameter("clientftfid", clientFileTransferId));
        add(new KeyValueParameter("name", filePath));
        add(new KeyValueParameter("cid", channelId));
        add(new KeyValueParameter("cpw", channelPassword));
        add(new KeyValueParameter("seekpos", seekPos));
    }

}
