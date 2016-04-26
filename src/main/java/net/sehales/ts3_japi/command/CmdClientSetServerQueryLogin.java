package net.sehales.ts3_japi.command;

import net.sehales.ts3_japi.command.parameter.KeyValueParameter;
import net.sehales.ts3_japi.property.ClientProperty;

public class CmdClientSetServerQueryLogin extends ArrayResponseCommand {

    public CmdClientSetServerQueryLogin(String loginName) {
        super("clientsetserverquerylogin");
        add(new KeyValueParameter("client_login_name", loginName));
    }

    /**
     * @return the new generated password
     */
    @Override
    public String getResponseWrapper() {
        return response.getWrapper().getString(ClientProperty.CLIENT_LOGIN_PASSWORD);
    }

}
