package net.sehales.ts3_japi.command;

import net.sehales.ts3_japi.command.parameter.KeyValueParameter;

public class CmdServerGroupDelClient extends Command {

    public CmdServerGroupDelClient(int serverGroupId, int clientDbId) {
        super("servergroupdelclient");
        add(new KeyValueParameter("sgid", serverGroupId));
        add(new KeyValueParameter("cldbid", clientDbId));
    }

}
