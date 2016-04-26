package net.sehales.ts3_japi.command;

import net.sehales.ts3_japi.command.parameter.KeyValueParameter;

public class CmdServerStop extends Command {
    public CmdServerStop(int id) {
        super("serverstop");
        add(new KeyValueParameter("sid", id));
    }
}
