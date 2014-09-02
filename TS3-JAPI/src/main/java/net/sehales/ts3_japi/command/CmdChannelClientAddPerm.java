package net.sehales.ts3_japi.command;

import net.sehales.ts3_japi.command.parameter.ArrayParameter;
import net.sehales.ts3_japi.command.parameter.KeyValueParameter;
import net.sehales.ts3_japi.command.parameter.ListParameter;

public class CmdChannelClientAddPerm extends Command {
    private ArrayParameter array = new ArrayParameter();

    public CmdChannelClientAddPerm(int channelId, int clientDbId) {
        super("channelclientaddperm");
        add(new KeyValueParameter("cid", channelId));
        add(new KeyValueParameter("cldbid", clientDbId));
    }

    public CmdChannelClientAddPerm(int channelId, int clientDbId, int permId, int permValue) {
        this(channelId, clientDbId);
        addPerm(permId, permValue);
    }

    public CmdChannelClientAddPerm(int channelId, int clientDbId, String permsId, int permValue) {
        this(channelId, clientDbId);
        addPerm(permsId, permValue);
    }

    public CmdChannelClientAddPerm addPerm(int permId, int permValue) {
        array.add(new ListParameter(
                        new KeyValueParameter("permid", permId),
                        new KeyValueParameter("permvalue", permValue)
                        ));
        return this;
    }

    public CmdChannelClientAddPerm addPerm(String permsId, int permValue) {
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
