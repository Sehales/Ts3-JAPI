package net.sehales.ts3_japi.command;

import net.sehales.ts3_japi.command.parameter.ArrayParameter;
import net.sehales.ts3_japi.command.parameter.KeyValueParameter;
import net.sehales.ts3_japi.command.parameter.ListParameter;
import net.sehales.ts3_japi.property.DefaultAutoPermGroupType;
import net.sehales.ts3_japi.util.QueryUtils;

public class CmdServerGroupAutoAddPerm extends Command {

    private ArrayParameter array = new ArrayParameter();

    public CmdServerGroupAutoAddPerm(DefaultAutoPermGroupType groupType) {
        this(groupType.getIndex());
    }

    public CmdServerGroupAutoAddPerm(DefaultAutoPermGroupType groupType, int permId, int permValue, boolean permNegated, boolean permSkip) {
        this(groupType);
        addPerm(permId, permValue, permNegated, permSkip);
    }

    public CmdServerGroupAutoAddPerm(DefaultAutoPermGroupType groupType, String permsId, int permValue, boolean permNegated, boolean permSkip) {
        this(groupType);
        addPerm(permsId, permValue, permNegated, permSkip);
    }

    public CmdServerGroupAutoAddPerm(int groupType) {
        super("servergroupautoaddperm");
        add(new KeyValueParameter("sgtype", groupType));
    }

    public CmdServerGroupAutoAddPerm(int groupType, int permId, int permValue, boolean permNegated, boolean permSkip) {
        this(groupType);
        addPerm(permId, permValue, permNegated, permSkip);
    }

    public CmdServerGroupAutoAddPerm(int groupType, String permsId, int permValue, boolean permNegated, boolean permSkip) {
        this(groupType);
        addPerm(permsId, permValue, permNegated, permSkip);
    }

    public CmdServerGroupAutoAddPerm addPerm(int permId, int permValue, boolean permNegated, boolean permSkip) {
        array.add(new ListParameter(
                        new KeyValueParameter("permid", permId),
                        new KeyValueParameter("permvalue", permValue),
                        new KeyValueParameter("permnegated", QueryUtils.toInt(permNegated)),
                        new KeyValueParameter("permskip", QueryUtils.toInt(permSkip))
                        ));
        return this;
    }

    public CmdServerGroupAutoAddPerm addPerm(String permsId, int permValue, boolean permNegated, boolean permSkip) {
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
