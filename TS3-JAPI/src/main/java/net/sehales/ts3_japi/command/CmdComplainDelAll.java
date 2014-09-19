package net.sehales.ts3_japi.command;

import net.sehales.ts3_japi.command.parameter.KeyValueParameter;

public class CmdComplainDelAll extends Command {

    public CmdComplainDelAll(int targetClientDbId) {
        super("complaindelall");
        add(new KeyValueParameter("tcldbid", targetClientDbId));
    }

}
