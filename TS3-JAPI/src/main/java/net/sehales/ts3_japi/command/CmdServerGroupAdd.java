package net.sehales.ts3_japi.command;

import net.sehales.ts3_japi.command.parameter.KeyValueParameter;
import net.sehales.ts3_japi.property.ServerGroupDbType;

public class CmdServerGroupAdd extends Command {

    public CmdServerGroupAdd(String name) {
        super("servergroupadd");
        add(new KeyValueParameter("name", name));
    }

    public CmdServerGroupAdd(String name, ServerGroupDbType type) {
        this(name);
        add(new KeyValueParameter("type", type.getIndex()));
    }

}
