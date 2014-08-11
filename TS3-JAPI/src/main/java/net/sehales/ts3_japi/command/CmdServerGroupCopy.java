package net.sehales.ts3_japi.command;

import net.sehales.ts3_japi.command.parameter.KeyValueParameter;
import net.sehales.ts3_japi.property.ServerGroupDbType;

public class CmdServerGroupCopy extends Command {

    public CmdServerGroupCopy(String name, int sourceGroupId) {
        super("servergroupcopy");
        add(new KeyValueParameter("ssgid", sourceGroupId));
        add(new KeyValueParameter("name", name));
        add(new KeyValueParameter("tsgid", 0));
        add(new KeyValueParameter("type", ServerGroupDbType.Regular.getIndex()));
    }

    public CmdServerGroupCopy(String name, int sourceGroupId, int targetGroupId) {
        super("servergroupcopy");
        add(new KeyValueParameter("ssgid", sourceGroupId));
        add(new KeyValueParameter("name", name));
        add(new KeyValueParameter("tsgid", targetGroupId));
        add(new KeyValueParameter("type", ServerGroupDbType.Regular.getIndex()));
    }

    public CmdServerGroupCopy(String name, int sourceGroupId, ServerGroupDbType type) {
        super("servergroupcopy");
        add(new KeyValueParameter("ssgid", sourceGroupId));
        add(new KeyValueParameter("name", name));
        add(new KeyValueParameter("tsgid", 0));
        add(new KeyValueParameter("type", type.getIndex()));
    }
}
