package net.sehales.ts3_japi.command;

import net.sehales.ts3_japi.command.parameter.KeyValueParameter;

public class CmdPermFind extends Command {

    private CmdPermFind() {
        super("permfind");
    }

    public CmdPermFind(int permId) {
        this();
        add(new KeyValueParameter("permid", permId));
    }

    public CmdPermFind(String permsId) {
        this();
        add(new KeyValueParameter("permsid", permsId));
    }

}
