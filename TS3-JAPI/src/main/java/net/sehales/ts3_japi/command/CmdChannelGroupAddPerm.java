package net.sehales.ts3_japi.command;

import net.sehales.ts3_japi.command.parameter.ArrayParameter;
import net.sehales.ts3_japi.command.parameter.KeyValueParameter;
import net.sehales.ts3_japi.command.parameter.ListParameter;

public class CmdChannelGroupAddPerm extends Command {
    private ArrayParameter array = new ArrayParameter();

    public CmdChannelGroupAddPerm(int channelGroupId) {
        super("channelgroupaddperm");
        add(new KeyValueParameter("cgid", channelGroupId));
    }

    public CmdChannelGroupAddPerm(int channelGroupId, int permId, long permValue) {
        this(channelGroupId);
        addPerm(permId, permValue);
    }

    public CmdChannelGroupAddPerm(int channelGroupId, String permsId, long permValue) {
        this(channelGroupId);
        addPerm(permsId, permValue);
    }

    public CmdChannelGroupAddPerm addPerm(int permId, long permValue) {
        array.add(new ListParameter(
                        new KeyValueParameter("permid", permId),
                        new KeyValueParameter("permvalue", permValue)
                        ));
        return this;
    }

    public CmdChannelGroupAddPerm addPerm(String permsId, long permValue) {
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
