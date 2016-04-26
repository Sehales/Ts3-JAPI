package net.sehales.ts3_japi.command;

import net.sehales.ts3_japi.command.parameter.ArrayParameter;
import net.sehales.ts3_japi.command.parameter.KeyValueParameter;

public class CmdChannelDelPerm extends Command {

    private ArrayParameter array = new ArrayParameter();

    public CmdChannelDelPerm(int channelId) {
        super("channeldelperm");
        add(new KeyValueParameter("cid", channelId));
    }

    public CmdChannelDelPerm(int channelId, int permId) {
        this(channelId);
        addPerm(permId);
    }

    public CmdChannelDelPerm(int channelId, String permsId) {
        this(channelId);
        addPerm(permsId);
    }

    public CmdChannelDelPerm addPerm(int permId) {
        array.add(new KeyValueParameter("permid", permId));
        return this;
    }

    public CmdChannelDelPerm addPerm(String permsId) {
        array.add(new KeyValueParameter("permsid", permsId));
        return this;
    }

    @Override
    public String buildString() {
        add(array);
        return super.buildString();
    }
}
