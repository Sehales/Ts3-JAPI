package net.sehales.ts3_japi.command;

import net.sehales.ts3_japi.command.parameter.KeyValueParameter;
import net.sehales.ts3_japi.command.parameter.OptionParameter;

public class CmdServerGroupPermList extends ArrayResponseCommand {

    public CmdServerGroupPermList(int serverGroupId) {
        super("servergrouppermlist");
        add(new KeyValueParameter("sgid", serverGroupId));
    }

    /**
     * @return permission names instead of internal ids
     */
    public CmdServerGroupPermList permsId() {
        add(new OptionParameter("permsid"));
        return this;
    }

}
