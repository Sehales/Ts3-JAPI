package net.sehales.ts3_japi.command;

import net.sehales.ts3_japi.command.parameter.KeyValueParameter;
import net.sehales.ts3_japi.property.GroupDbType;

public class CmdServerGroupCopy extends ArrayResponseCommand {

    public CmdServerGroupCopy(String name, int sourceGroupId) {
        super("servergroupcopy");
        add(new KeyValueParameter("ssgid", sourceGroupId));
        add(new KeyValueParameter("name", name));
        add(new KeyValueParameter("tsgid", 0));
        add(new KeyValueParameter("type", GroupDbType.REGULAR.getIndex()));
    }

    public CmdServerGroupCopy(String name, int sourceGroupId, GroupDbType type) {
        super("servergroupcopy");
        add(new KeyValueParameter("ssgid", sourceGroupId));
        add(new KeyValueParameter("name", name));
        add(new KeyValueParameter("tsgid", 0));
        add(new KeyValueParameter("type", type.getIndex()));
    }

    public CmdServerGroupCopy(String name, int sourceGroupId, int targetGroupId) {
        super("servergroupcopy");
        add(new KeyValueParameter("ssgid", sourceGroupId));
        add(new KeyValueParameter("name", name));
        add(new KeyValueParameter("tsgid", targetGroupId));
        add(new KeyValueParameter("type", GroupDbType.REGULAR.getIndex()));
    }
}
