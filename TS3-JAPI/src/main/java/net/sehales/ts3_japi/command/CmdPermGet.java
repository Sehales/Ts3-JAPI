package net.sehales.ts3_japi.command;

import net.sehales.ts3_japi.command.parameter.KeyValueParameter;

public class CmdPermGet extends ArrayResponseCommand {

    private CmdPermGet() {
        super("permget");
    }

    public CmdPermGet(int permId) {
        this();
        add(new KeyValueParameter("permid", permId));
    }

    public CmdPermGet(String permsId) {
        this();
        add(new KeyValueParameter("permsid", permsId));
    }

}
