package net.sehales.ts3_japi.command;

import net.sehales.ts3_japi.command.parameter.KeyValueParameter;

public class CmdPrivilegeKeyDelete extends Command {

    public CmdPrivilegeKeyDelete(String token) {
        super("privilegekeydelete");
        add(new KeyValueParameter("token", token));
    }

}
