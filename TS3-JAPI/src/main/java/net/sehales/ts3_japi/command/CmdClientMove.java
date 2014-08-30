package net.sehales.ts3_japi.command;

import net.sehales.ts3_japi.command.parameter.ArrayParameter;
import net.sehales.ts3_japi.command.parameter.KeyValueParameter;

public class CmdClientMove extends Command {

    private ArrayParameter array = new ArrayParameter();

    public CmdClientMove() {
        super("clientmove");
    }

    @Override
    public String buildString() {
        add(array);
        return super.buildString();
    }

    public CmdClientMove clientId(int clientId) {
        array.add(new KeyValueParameter("clid", clientId));
        return this;
    }

    public CmdClientMove toChannel(int channelId) {
        add(new KeyValueParameter("cid", channelId));
        return this;
    }

    public CmdClientMove withPassword(String password) {
        add(new KeyValueParameter("cpw", password));
        return this;
    }

}
