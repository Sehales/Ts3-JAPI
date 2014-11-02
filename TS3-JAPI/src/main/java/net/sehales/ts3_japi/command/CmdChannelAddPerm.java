package net.sehales.ts3_japi.command;

import net.sehales.ts3_japi.command.parameter.ArrayParameter;
import net.sehales.ts3_japi.command.parameter.KeyValueParameter;
import net.sehales.ts3_japi.command.parameter.ListParameter;

public class CmdChannelAddPerm extends Command {

    private ArrayParameter array = new ArrayParameter();

    public CmdChannelAddPerm(int channelId) {
        super("channeladdperm");
        add(new KeyValueParameter("cid", channelId));
    }

    public CmdChannelAddPerm(int channelId, int permId, long permValue) {
        this(channelId);
        addPerm(permId, permValue);
    }

    public CmdChannelAddPerm(int channelId, String permsId, long permValue) {
        this(channelId);
        addPerm(permsId, permValue);
    }

    public CmdChannelAddPerm addPerm(int permId, long permValue) {
        array.add(new ListParameter(
                        new KeyValueParameter("permid", permId),
                        new KeyValueParameter("permvalue", permValue)
                        ));
        return this;
    }

    public CmdChannelAddPerm addPerm(String permsId, long permValue) {
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
