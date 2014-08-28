package net.sehales.ts3_japi.command;

import net.sehales.ts3_japi.command.parameter.KeyValueParameter;

public class CmdClientDbDelete extends Command {

    public CmdClientDbDelete(int clientDbId) {
        super("clientdbdelete");
        add(new KeyValueParameter("cldbid", clientDbId));
    }

}
