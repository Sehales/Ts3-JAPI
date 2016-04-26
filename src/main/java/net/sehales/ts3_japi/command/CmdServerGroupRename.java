package net.sehales.ts3_japi.command;

import net.sehales.ts3_japi.command.parameter.KeyValueParameter;

public class CmdServerGroupRename extends Command {

    public CmdServerGroupRename(int serverGroupId, String newName) {
        super("servergrouprename");
        add(new KeyValueParameter("sgid", serverGroupId));
        add(new KeyValueParameter("name", newName));
    }

}
