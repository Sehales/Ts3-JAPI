package net.sehales.ts3_japi.command;

import net.sehales.ts3_japi.command.parameter.KeyValueParameter;

public class CmdClientGetNameFromDbId extends ArrayResponseCommand {

    public CmdClientGetNameFromDbId(int clientDbId) {
        super("clientgetnamefromdbid");
        add(new KeyValueParameter("cldbid", clientDbId));
    }

}
