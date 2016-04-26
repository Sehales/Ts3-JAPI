package net.sehales.ts3_japi.command;

import net.sehales.ts3_japi.command.parameter.KeyValueParameter;

public class CmdServerGroupAddClient extends Command {

    public CmdServerGroupAddClient(int serverGroupId, int clientDbId) {
        super("servergroupaddclient");
        add(new KeyValueParameter("sgid", serverGroupId));
        add(new KeyValueParameter("cldbid", clientDbId));
    }

}
