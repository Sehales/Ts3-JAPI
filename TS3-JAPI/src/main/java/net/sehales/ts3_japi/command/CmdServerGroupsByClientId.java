package net.sehales.ts3_japi.command;

import net.sehales.ts3_japi.command.parameter.KeyValueParameter;

public class CmdServerGroupsByClientId extends ArrayResponseCommand {

    public CmdServerGroupsByClientId(int clientDbId) {
        super("servergroupsbyclientid");
        add(new KeyValueParameter("cldbid", clientDbId));
    }

}
