package net.sehales.ts3_japi.command;

import net.sehales.ts3_japi.command.parameter.KeyValueParameter;

public class CmdServerDelete extends Command {

    public CmdServerDelete(int serverId) {
        super("serverdelete");
        add(new KeyValueParameter("sid", serverId));
    }

}
