package net.sehales.ts3_japi.command;

import net.sehales.ts3_japi.command.parameter.KeyValueParameter;

public class CmdFtRenameFile extends Command {

    public CmdFtRenameFile(int channelId, String channelPassword, String oldPath, String newPath) {
        super("ftrenamefile");
        add(new KeyValueParameter("cid", channelId));
        add(new KeyValueParameter("cpw", channelPassword));
        add(new KeyValueParameter("oldname", oldPath));
        add(new KeyValueParameter("newname", newPath));
    }

    public CmdFtRenameFile(int channelId, String channelPassword, String oldPath, String newPath, int targetChannelId, String targetChannelPassword) {
        this(channelId, channelPassword, oldPath, newPath);
        add(new KeyValueParameter("tcid", targetChannelId));
        add(new KeyValueParameter("tcpw", targetChannelPassword));
    }
}
