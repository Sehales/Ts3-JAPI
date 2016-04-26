package net.sehales.ts3_japi.command;

import net.sehales.ts3_japi.command.parameter.KeyValueParameter;

public class CmdMessageAdd extends Command {

    public CmdMessageAdd(String clientUid, String subject, String message) {
        super("messageadd");
        add(new KeyValueParameter("cluid", clientUid));
        add(new KeyValueParameter("subject", subject));
        add(new KeyValueParameter("message", message));
    }

}
