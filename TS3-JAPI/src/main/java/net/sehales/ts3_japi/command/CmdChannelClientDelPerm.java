package net.sehales.ts3_japi.command;

import net.sehales.ts3_japi.command.parameter.ArrayParameter;
import net.sehales.ts3_japi.command.parameter.KeyValueParameter;

public class CmdChannelClientDelPerm extends Command {
    private ArrayParameter array = new ArrayParameter();

    public CmdChannelClientDelPerm(int channelId, int clientDbId) {
        super("channelclientdelperm");
        add(new KeyValueParameter("cid", channelId));
        add(new KeyValueParameter("cldbid", clientDbId));
    }

    public CmdChannelClientDelPerm(int channelId, int clientDbId, int permId) {
        this(channelId, clientDbId);
        addPerm(permId);
    }

    public CmdChannelClientDelPerm(int channelId, int clientDbId, String permsId) {
        this(channelId, clientDbId);
        addPerm(permsId);
    }

    public CmdChannelClientDelPerm addPerm(int permId) {
        array.add(new KeyValueParameter("permid", permId));
        return this;
    }

    public CmdChannelClientDelPerm addPerm(String permsId) {
        array.add(new KeyValueParameter("permsid", permsId));
        return this;
    }

    @Override
    public String buildString() {
        add(array);
        return super.buildString();
    }
}
