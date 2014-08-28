package net.sehales.ts3_japi.command;

import net.sehales.ts3_japi.command.parameter.KeyValueParameter;

public class CmdClientGetNameFromUid extends Command {
    public CmdClientGetNameFromUid(String clientUid) {
        super("clientgetnamefromuid");
        add(new KeyValueParameter("cluid", clientUid));
    }
}
