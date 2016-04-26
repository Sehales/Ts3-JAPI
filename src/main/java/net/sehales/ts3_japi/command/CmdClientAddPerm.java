package net.sehales.ts3_japi.command;

import net.sehales.ts3_japi.command.parameter.ArrayParameter;
import net.sehales.ts3_japi.command.parameter.KeyValueParameter;
import net.sehales.ts3_japi.command.parameter.ListParameter;
import net.sehales.ts3_japi.util.QueryUtils;

public class CmdClientAddPerm extends Command {
    private ArrayParameter array = new ArrayParameter();

    public CmdClientAddPerm(int clientDbId) {
        super("clientaddperm");
        add(new KeyValueParameter("cldbid", clientDbId));
    }

    public CmdClientAddPerm(int clientDbId, int permId, int permValue, boolean permSkip) {
        this(clientDbId);
        addPerm(permId, permValue, permSkip);
    }

    public CmdClientAddPerm(int clientDbId, String permsId, int permValue, boolean permSkip) {
        this(clientDbId);
        addPerm(permsId, permValue, permSkip);
    }

    public CmdClientAddPerm addPerm(int permId, int permValue, boolean permSkip) {
        array.add(new ListParameter(
                        new KeyValueParameter("permid", permId),
                        new KeyValueParameter("permvalue", permValue),
                        new KeyValueParameter("permskip", QueryUtils.toInt(permSkip))
                        ));
        return this;
    }

    public CmdClientAddPerm addPerm(String permsId, int permValue, boolean permSkip) {
        array.add(new ListParameter(
                        new KeyValueParameter("permsid", permsId),
                        new KeyValueParameter("permvalue", permValue),
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
