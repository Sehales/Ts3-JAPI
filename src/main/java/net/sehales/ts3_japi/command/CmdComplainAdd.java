package net.sehales.ts3_japi.command;

import net.sehales.ts3_japi.command.parameter.KeyValueParameter;

public class CmdComplainAdd extends Command {

    public CmdComplainAdd(int targetClientDbId, String message) {
        super("complainadd");
        add(new KeyValueParameter("tcldbid", targetClientDbId));
        add(new KeyValueParameter("message", message));
    }
}
