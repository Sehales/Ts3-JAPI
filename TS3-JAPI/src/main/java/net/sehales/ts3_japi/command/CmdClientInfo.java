package net.sehales.ts3_japi.command;

import net.sehales.ts3_japi.command.parameter.KeyValueParameter;

public class CmdClientInfo extends ArrayResponseCommand {

    public CmdClientInfo(int clientId) {
        super("clientinfo");
        add(new KeyValueParameter("clid", clientId));
    }

}
