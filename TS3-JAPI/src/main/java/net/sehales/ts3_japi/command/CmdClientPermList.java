package net.sehales.ts3_japi.command;

import net.sehales.ts3_japi.command.parameter.KeyValueParameter;
import net.sehales.ts3_japi.command.parameter.OptionParameter;

public class CmdClientPermList extends ArrayResponseCommand {

    public CmdClientPermList(int clientDbId) {
        super("clientpermlist");
        add(new KeyValueParameter("cldbid", clientDbId));
    }

    public CmdClientPermList permsid() {
        add(new OptionParameter("permsid"));
        return this;
    }
}
