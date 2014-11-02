package net.sehales.ts3_japi.command;

import net.sehales.ts3_japi.command.parameter.KeyValueParameter;

public class CmdCustomInfo extends ArrayResponseCommand {

    public CmdCustomInfo(long clientDbId) {
        super("custominfo");
        add(new KeyValueParameter("cldbid", clientDbId));
    }

}
