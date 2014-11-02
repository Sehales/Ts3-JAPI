package net.sehales.ts3_japi.command;

import net.sehales.ts3_japi.command.parameter.KeyValueParameter;
import net.sehales.ts3_japi.property.GroupDbType;

public class CmdServerGroupAdd extends ArrayResponseCommand {

    public CmdServerGroupAdd(String name) {
        super("servergroupadd");
        add(new KeyValueParameter("name", name));
    }

    public CmdServerGroupAdd(String name, GroupDbType type) {
        this(name);
        add(new KeyValueParameter("type", type.getIndex()));
    }

}
