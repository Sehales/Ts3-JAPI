package net.sehales.ts3_japi.command;

import net.sehales.ts3_japi.command.parameter.KeyValueParameter;
import net.sehales.ts3_japi.command.parameter.OptionParameter;

public class CmdServerGroupClientList extends ArrayResponseCommand {

    public CmdServerGroupClientList(int serverGroupId) {
        super("servergroupclientlist");
        add(new KeyValueParameter("sgid", serverGroupId));
    }

    public CmdServerGroupClientList names() {
        add(new OptionParameter("names"));
        return this;
    }
}
