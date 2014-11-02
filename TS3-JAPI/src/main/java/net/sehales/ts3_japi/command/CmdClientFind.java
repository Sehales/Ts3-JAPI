package net.sehales.ts3_japi.command;

import net.sehales.ts3_japi.command.parameter.KeyValueParameter;

public class CmdClientFind extends ArrayResponseCommand {

    public CmdClientFind(String pattern) {
        super("clientfind");
        add(new KeyValueParameter("pattern", pattern));
    }

}
