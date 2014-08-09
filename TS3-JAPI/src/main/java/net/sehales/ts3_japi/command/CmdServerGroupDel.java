package net.sehales.ts3_japi.command;

import net.sehales.ts3_japi.command.parameter.KeyValueParameter;

public class CmdServerGroupDel extends Command {

    public CmdServerGroupDel(int groupId, boolean force) {
        super("servergroupdel");
        add(new KeyValueParameter("sgid", groupId));
        add(new KeyValueParameter("force", force ? 1 : 0));
    }

}
