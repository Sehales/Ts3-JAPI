package net.sehales.ts3_japi.command;

import net.sehales.ts3_japi.command.parameter.ArrayParameter;
import net.sehales.ts3_japi.command.parameter.KeyValueParameter;
import net.sehales.ts3_japi.property.DefaultAutoPermGroupType;

public class CmdServerGroupAutoDelPerm extends Command {
    private ArrayParameter array = new ArrayParameter();

    public CmdServerGroupAutoDelPerm(DefaultAutoPermGroupType groupType) {
        this(groupType.getIndex());
    }

    public CmdServerGroupAutoDelPerm(int groupType) {
        super("servergroupautodelperm");
        add(new KeyValueParameter("sgtype", groupType));
    }

    public CmdServerGroupAutoDelPerm(int serverGroupId, int permId) {
        this(serverGroupId);
        addPerm(permId);
    }

    public CmdServerGroupAutoDelPerm(int serverGroupId, String permsId) {
        this(serverGroupId);
        addPerm(permsId);
    }

    public CmdServerGroupAutoDelPerm addPerm(int permId) {
        array.add(new KeyValueParameter("permid", permId));
        return this;
    }

    public CmdServerGroupAutoDelPerm addPerm(String permsId) {
        array.add(new KeyValueParameter("permsid", permsId));
        return this;
    }

    @Override
    public String buildString() {
        add(array);
        return super.buildString();
    }

}
