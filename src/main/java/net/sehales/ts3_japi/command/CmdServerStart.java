package net.sehales.ts3_japi.command;

import net.sehales.ts3_japi.command.parameter.KeyValueParameter;

public class CmdServerStart extends Command {

    public CmdServerStart(int id) {
        super("serverstart");
        add(new KeyValueParameter("sid", id));
    }

}
