package net.sehales.ts3_japi.command;

import net.sehales.ts3_japi.command.parameter.KeyValueParameter;

public class CmdClientGetIds extends ArrayResponseCommand {

    public CmdClientGetIds(String clientUid) {
        super("clientgetids");
        add(new KeyValueParameter("cluid", clientUid));
    }

}
