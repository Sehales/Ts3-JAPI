package net.sehales.ts3_japi.command;

import net.sehales.ts3_japi.command.parameter.ArrayParameter;
import net.sehales.ts3_japi.command.parameter.KeyValueParameter;

public class CmdChannelGroupDelPerm extends Command {
    private ArrayParameter array = new ArrayParameter();

    public CmdChannelGroupDelPerm(int channelGroupId) {
        super("channelgroupdelperm");
        add(new KeyValueParameter("cgid", channelGroupId));
    }

    public CmdChannelGroupDelPerm(int channelGroupId, int permId) {
        this(channelGroupId);
        addPerm(permId);
    }

    public CmdChannelGroupDelPerm(int channelGroupId, String permsId) {
        this(channelGroupId);
        addPerm(permsId);
    }

    public CmdChannelGroupDelPerm addPerm(int permId) {
        array.add(new KeyValueParameter("permid", permId));
        return this;
    }

    public CmdChannelGroupDelPerm addPerm(String permsId) {
        array.add(new KeyValueParameter("permsid", permsId));
        return this;
    }

    @Override
    public String buildString() {
        add(array);
        return super.buildString();
    }

}
