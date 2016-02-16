package net.sehales.ts3_japi.command;

import net.sehales.ts3_japi.command.parameter.KeyValueParameter;
import net.sehales.ts3_japi.util.QueryUtils;

public class CmdMessageUpdateFlag extends Command {

    public CmdMessageUpdateFlag(int msgId, boolean read) {
        super("messageupdateflag");
        add(new KeyValueParameter("msgid", msgId));
        add(new KeyValueParameter("flag", QueryUtils.toInt(read)));
    }

}
