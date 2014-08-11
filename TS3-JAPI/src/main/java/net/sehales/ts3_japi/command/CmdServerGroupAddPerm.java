package net.sehales.ts3_japi.command;

import net.sehales.ts3_japi.QueryUtils;
import net.sehales.ts3_japi.command.parameter.ArrayParameter;
import net.sehales.ts3_japi.command.parameter.KeyValueParameter;
import net.sehales.ts3_japi.command.parameter.ListParameter;

public class CmdServerGroupAddPerm extends Command {
    private ArrayParameter array = new ArrayParameter();

    public CmdServerGroupAddPerm() {
        super("servergroupaddperm");
    }

    public CmdServerGroupAddPerm(int permId, int permValue, boolean permNegated, boolean permSkip) {
        this();
        addPerm(permId, permValue, permNegated, permSkip);
    }

    public CmdServerGroupAddPerm(String permsId, int permValue, boolean permNegated, boolean permSkip) {
        this();
        addPerm(permsId, permValue, permNegated, permSkip);
    }

    public CmdServerGroupAddPerm addPerm(int permId, int permValue, boolean permNegated, boolean permSkip) {
        array.add(new ListParameter(
                        new KeyValueParameter("permid", permId),
                        new KeyValueParameter("permvalue", permValue),
                        new KeyValueParameter("permNegated", QueryUtils.toInt(permNegated)),
                        new KeyValueParameter("permSkip", QueryUtils.toInt(permSkip))
                        ));
        return this;
    }

    public CmdServerGroupAddPerm addPerm(String permsId, int permValue, boolean permNegated, boolean permSkip) {
        array.add(new ListParameter(
                        new KeyValueParameter("permsid", permsId),
                        new KeyValueParameter("permvalue", permValue),
                        new KeyValueParameter("permNegated", QueryUtils.toInt(permNegated)),
                        new KeyValueParameter("permSkip", QueryUtils.toInt(permSkip))
                        ));
        return this;
    }

    @Override
    public String buildString() {
        add(array);
        return super.buildString();
    }

}
