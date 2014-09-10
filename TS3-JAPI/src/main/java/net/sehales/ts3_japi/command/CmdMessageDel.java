package net.sehales.ts3_japi.command;

import net.sehales.ts3_japi.command.parameter.KeyValueParameter;

public class CmdMessageDel extends Command {

    public CmdMessageDel(int msgId) {
        super("messagedel");
        add(new KeyValueParameter("msgid", msgId));
    }

}
