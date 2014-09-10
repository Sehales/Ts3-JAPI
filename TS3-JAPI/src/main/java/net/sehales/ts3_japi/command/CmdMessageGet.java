package net.sehales.ts3_japi.command;

import net.sehales.ts3_japi.command.parameter.KeyValueParameter;

public class CmdMessageGet extends Command {

    public CmdMessageGet(int msgId) {
        super("messageget");
        add(new KeyValueParameter("msgid", msgId));
    }
}
