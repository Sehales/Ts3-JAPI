package net.sehales.ts3_japi.command;

import net.sehales.ts3_japi.command.parameter.KeyValueParameter;

public class CmdClientPoke extends Command {

    public CmdClientPoke(int clientId, String msg) {
        super("clientpoke");
        add(new KeyValueParameter("clid", clientId));
        add(new KeyValueParameter("msg", msg));
    }

}
