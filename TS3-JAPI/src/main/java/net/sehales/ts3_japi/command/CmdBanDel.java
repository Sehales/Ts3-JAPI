package net.sehales.ts3_japi.command;

import net.sehales.ts3_japi.command.parameter.KeyValueParameter;

public class CmdBanDel extends Command {

    public CmdBanDel(int banId) {
        super("bandel");
        add(new KeyValueParameter("banid", banId));
    }

}
