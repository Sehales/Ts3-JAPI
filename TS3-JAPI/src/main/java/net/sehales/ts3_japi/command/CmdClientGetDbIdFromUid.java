package net.sehales.ts3_japi.command;

import net.sehales.ts3_japi.command.parameter.KeyValueParameter;

public class CmdClientGetDbIdFromUid extends ArrayResponseCommand {

    public CmdClientGetDbIdFromUid(String clientUid) {
        super("clientgetdbidfromuid");
        add(new KeyValueParameter("cluid", clientUid));
    }

}
