package net.sehales.ts3_japi.command;

import net.sehales.ts3_japi.command.parameter.KeyValueParameter;

public class CmdComplainDel extends Command {
    public CmdComplainDel(int targetClientDbId, int fromClientDbId) {
        super("complaindel");
        add(new KeyValueParameter("tcldbid", targetClientDbId));
        add(new KeyValueParameter("fcldbid", fromClientDbId));
    }
}
