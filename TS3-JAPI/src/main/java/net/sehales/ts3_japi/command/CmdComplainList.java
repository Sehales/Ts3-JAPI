package net.sehales.ts3_japi.command;

import net.sehales.ts3_japi.command.parameter.KeyValueParameter;

public class CmdComplainList extends Command {

    public CmdComplainList(int targetClientDbId) {
        super("complainlist");
        add(new KeyValueParameter("tcldbid", targetClientDbId));
    }

}
