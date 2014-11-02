package net.sehales.ts3_japi.command;

import net.sehales.ts3_japi.QueryUtils;
import net.sehales.ts3_japi.command.parameter.ArrayParameter;
import net.sehales.ts3_japi.command.parameter.KeyValueParameter;
import net.sehales.ts3_japi.command.parameter.ListParameter;

public class CmdServerGroupAddPerm extends Command {
    private ArrayParameter array = new ArrayParameter();

    public CmdServerGroupAddPerm(int serverGroupid) {
        super("servergroupaddperm");
        add(new KeyValueParameter("sgid", serverGroupid));
    }

    public CmdServerGroupAddPerm(int serverGroupid, int permId, long permValue, boolean permNegated, boolean permSkip) {
        this(serverGroupid);
        addPerm(permId, permValue, permNegated, permSkip);
    }

    public CmdServerGroupAddPerm(int serverGroupid, String permsId, long permValue, boolean permNegated, boolean permSkip) {
        this(serverGroupid);
        addPerm(permsId, permValue, permNegated, permSkip);
    }

    public CmdServerGroupAddPerm addPerm(int permId, long permValue, boolean permNegated, boolean permSkip) {
        array.add(new ListParameter(
                        new KeyValueParameter("permid", permId),
                        new KeyValueParameter("permvalue", permValue),
                        new KeyValueParameter("permnegated", QueryUtils.toInt(permNegated)),
                        new KeyValueParameter("permskip", QueryUtils.toInt(permSkip))
                        ));
        return this;
    }

    public CmdServerGroupAddPerm addPerm(String permsId, long permValue, boolean permNegated, boolean permSkip) {
        array.add(new ListParameter(
                        new KeyValueParameter("permsid", permsId),
                        new KeyValueParameter("permvalue", permValue),
                        new KeyValueParameter("permnegated", QueryUtils.toInt(permNegated)),
                        new KeyValueParameter("permskip", QueryUtils.toInt(permSkip))
                        ));
        return this;
    }

    @Override
    public String buildString() {
        add(array);
        return super.buildString();
    }

}
