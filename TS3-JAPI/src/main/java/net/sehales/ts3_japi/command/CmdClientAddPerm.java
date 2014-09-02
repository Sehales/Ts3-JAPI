package net.sehales.ts3_japi.command;

import net.sehales.ts3_japi.command.parameter.ArrayParameter;
import net.sehales.ts3_japi.command.parameter.KeyValueParameter;
import net.sehales.ts3_japi.command.parameter.ListParameter;

public class CmdClientAddPerm extends Command {
    private ArrayParameter array = new ArrayParameter();

    public CmdClientAddPerm(int clientDbId) {
        super("clientaddperm");
        add(new KeyValueParameter("cldbid", clientDbId));
    }

    public CmdClientAddPerm(int clientDbId, int permId, int permValue) {
        this(clientDbId);
        addPerm(permId, permValue);
    }

    public CmdClientAddPerm(int clientDbId, String permsId, int permValue) {
        this(clientDbId);
        addPerm(permsId, permValue);
    }

    public CmdClientAddPerm addPerm(int permId, int permValue) {
        array.add(new ListParameter(
                        new KeyValueParameter("permid", permId),
                        new KeyValueParameter("permvalue", permValue)
                        ));
        return this;
    }

    public CmdClientAddPerm addPerm(String permsId, int permValue) {
        array.add(new ListParameter(
                        new KeyValueParameter("permsid", permsId),
                        new KeyValueParameter("permvalue", permValue)
                        ));
        return this;
    }

    @Override
    public String buildString() {
        add(array);
        return super.buildString();
    }

}
