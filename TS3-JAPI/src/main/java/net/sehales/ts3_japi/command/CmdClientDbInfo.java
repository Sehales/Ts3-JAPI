package net.sehales.ts3_japi.command;

import net.sehales.ts3_japi.command.parameter.KeyValueParameter;

public class CmdClientDbInfo extends Command {

    public CmdClientDbInfo(int clientDbId) {
        super("clientdbinfo");
        add(new KeyValueParameter("cldbid", clientDbId));
    }

}
