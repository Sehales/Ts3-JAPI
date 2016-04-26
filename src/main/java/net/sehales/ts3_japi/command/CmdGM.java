package net.sehales.ts3_japi.command;

import net.sehales.ts3_japi.command.parameter.KeyValueParameter;

public class CmdGM extends Command {

    public CmdGM(String msg) {
        super("gm");
        add(new KeyValueParameter("msg", msg));
    }

}
