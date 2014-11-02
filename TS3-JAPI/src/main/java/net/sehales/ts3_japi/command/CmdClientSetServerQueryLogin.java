package net.sehales.ts3_japi.command;

import net.sehales.ts3_japi.command.parameter.KeyValueParameter;

public class CmdClientSetServerQueryLogin extends ArrayResponseCommand {

    public CmdClientSetServerQueryLogin(String loginName) {
        super("clientsetserverquerylogin");
        add(new KeyValueParameter("client_login_name", loginName));
    }

}
