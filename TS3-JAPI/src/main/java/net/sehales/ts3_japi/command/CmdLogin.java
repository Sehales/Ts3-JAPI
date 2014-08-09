package net.sehales.ts3_japi.command;

import net.sehales.ts3_japi.command.parameter.ValueParameter;
import net.sehales.ts3_japi.wrapper.Wrapper;

public class CmdLogin extends Command {

    public CmdLogin(String username, String password) {
        super("login");
        add(new ValueParameter(username));
        add(new ValueParameter(password));
    }

    @Override
    public Wrapper getResponseWrapper() {
        return null;
    }

}
