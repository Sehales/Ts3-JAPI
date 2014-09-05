package net.sehales.ts3_japi.command;

import net.sehales.ts3_japi.command.parameter.KeyValueParameter;

public class CmdPermIdGetByName extends Command {

    public CmdPermIdGetByName(String permsId) {
        super("permidgetbyname");
        add(new KeyValueParameter("permsid", permsId));
    }

}
