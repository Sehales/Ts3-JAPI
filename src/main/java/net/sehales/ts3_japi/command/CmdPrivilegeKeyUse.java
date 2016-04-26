package net.sehales.ts3_japi.command;

import net.sehales.ts3_japi.command.parameter.KeyValueParameter;

public class CmdPrivilegeKeyUse extends Command {

    public CmdPrivilegeKeyUse(String token) {
        super("privilegekeyuse");
        add(new KeyValueParameter("token", token));
    }

}
