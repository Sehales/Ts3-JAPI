package net.sehales.ts3_japi.command;

import net.sehales.ts3_japi.command.parameter.ArrayParameter;
import net.sehales.ts3_japi.command.parameter.KeyValueParameter;

public class CmdServerGroupDelPerm extends Command {
    private ArrayParameter array = new ArrayParameter();

    public CmdServerGroupDelPerm(int serverGroupId) {
        super("servergroupdelperm");
        add(new KeyValueParameter("sgid", serverGroupId));
    }

    public CmdServerGroupDelPerm(int serverGroupId, int permId) {
        this(serverGroupId);
        addPerm(permId);
    }

    public CmdServerGroupDelPerm(int serverGroupId, String permsId) {
        this(serverGroupId);
        addPerm(permsId);
    }

    public CmdServerGroupDelPerm addPerm(int permId) {
        array.add(new KeyValueParameter("permid", permId));
        return this;
    }

    public CmdServerGroupDelPerm addPerm(String permsId) {
        array.add(new KeyValueParameter("permid", permsId));
        return this;
    }

    @Override
    public String buildString() {
        add(array);
        return super.buildString();
    }

}
