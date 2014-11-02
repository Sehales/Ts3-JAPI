package net.sehales.ts3_japi.command;

import net.sehales.ts3_japi.command.parameter.OptionParameter;

public class CmdPermissionList extends ArrayResponseCommand {

    public CmdPermissionList() {
        super("permissionlist");
    }

    public CmdPermissionList listNew() {
        add(new OptionParameter("new"));
        return this;
    }
}
