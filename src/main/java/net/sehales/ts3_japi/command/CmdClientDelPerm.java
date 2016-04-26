package net.sehales.ts3_japi.command;

import net.sehales.ts3_japi.command.parameter.ArrayParameter;
import net.sehales.ts3_japi.command.parameter.KeyValueParameter;

public class CmdClientDelPerm extends Command {
    private ArrayParameter array = new ArrayParameter();

    public CmdClientDelPerm(int channelId) {
        super("clientdelperm");
        add(new KeyValueParameter("cid", channelId));
    }

    public CmdClientDelPerm(int channelId, int permId) {
        this(channelId);
        addPerm(permId);
    }

    public CmdClientDelPerm(int channelId, String permsId) {
        this(channelId);
        addPerm(permsId);
    }

    public CmdClientDelPerm addPerm(int permId) {
        array.add(new KeyValueParameter("permid", permId));
        return this;
    }

    public CmdClientDelPerm addPerm(String permsId) {
        array.add(new KeyValueParameter("permsid", permsId));
        return this;
    }

    @Override
    public String buildString() {
        add(array);
        return super.buildString();
    }
}
