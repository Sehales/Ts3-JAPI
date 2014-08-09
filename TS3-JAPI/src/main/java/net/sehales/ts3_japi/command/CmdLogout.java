package net.sehales.ts3_japi.command;

import net.sehales.ts3_japi.wrapper.Wrapper;

public class CmdLogout extends Command {

    public CmdLogout(String command) {
        super("logout");
    }

    @Override
    public Wrapper getResponseWrapper() {
        return null;
    }

}
