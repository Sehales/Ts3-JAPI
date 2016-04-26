package net.sehales.ts3_japi.command;

import net.sehales.ts3_japi.command.parameter.KeyValueParameter;
import net.sehales.ts3_japi.property.GroupDbType;
import net.sehales.ts3_japi.property.GroupProperty;

public class CmdServerGroupAdd extends ArrayResponseCommand {

    public CmdServerGroupAdd(String name) {
        super("servergroupadd");
        add(new KeyValueParameter("name", name));
    }

    public CmdServerGroupAdd(String name, GroupDbType type) {
        this(name);
        add(new KeyValueParameter("type", type.getIndex()));
    }

    /**
     * @return the server group id of the newly-created server group
     */
    @Override
    public Integer getResponseWrapper() {
        return response.getWrapper().getInt(GroupProperty.SGID);
    }

}
