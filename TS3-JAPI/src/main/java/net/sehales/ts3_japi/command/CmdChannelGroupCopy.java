package net.sehales.ts3_japi.command;

import net.sehales.ts3_japi.command.parameter.KeyValueParameter;
import net.sehales.ts3_japi.property.GroupDbType;

public class CmdChannelGroupCopy extends Command {

    public CmdChannelGroupCopy(String name, int sourceGroupId) {
        super("channelgroupcopy");
        add(new KeyValueParameter("scgid", sourceGroupId));
        add(new KeyValueParameter("name", name));
        add(new KeyValueParameter("tcgid", 0));
        add(new KeyValueParameter("type", GroupDbType.REGULAR.getIndex()));
    }

    public CmdChannelGroupCopy(String name, int sourceGroupId, int targetGroupId) {
        super("channelgroupcopy");
        add(new KeyValueParameter("scgid", sourceGroupId));
        add(new KeyValueParameter("name", name));
        add(new KeyValueParameter("tcgid", targetGroupId));
        add(new KeyValueParameter("type", GroupDbType.REGULAR.getIndex()));
    }

    public CmdChannelGroupCopy(String name, int sourceGroupId, GroupDbType type) {
        super("channelgroupcopy");
        add(new KeyValueParameter("scgid", sourceGroupId));
        add(new KeyValueParameter("name", name));
        add(new KeyValueParameter("tcgid", 0));
        add(new KeyValueParameter("type", type.getIndex()));
    }

}
