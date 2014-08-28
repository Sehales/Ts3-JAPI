package net.sehales.ts3_japi.command;

import net.sehales.ts3_japi.command.parameter.KeyValueParameter;

public class CmdClientGetNameFromDbId extends Command {

    public CmdClientGetNameFromDbId(int clientDbId) {
        super("clientgetnamefromdbid");
        add(new KeyValueParameter("cldbid", clientDbId));
    }

}
