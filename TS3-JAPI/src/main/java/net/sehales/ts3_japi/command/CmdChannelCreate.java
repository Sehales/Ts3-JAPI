package net.sehales.ts3_japi.command;

import net.sehales.ts3_japi.command.parameter.KeyValueParameter;
import net.sehales.ts3_japi.property.ChannelProperty;

public class CmdChannelCreate extends ArrayResponseCommand {
    public CmdChannelCreate(String name) {
        super("channelcreate");
        add(new KeyValueParameter("channel_name", name));
    }

    /**
     * All unchangeable properties passed into it will be ignored
     * 
     * @param property
     * @param value
     * @return
     */
    public CmdChannelCreate addParameter(ChannelProperty property, String value) {
        if (property.isChangeable()) {
            return addParameter(property.toString(), value);
        }
        return this;
    }

    public CmdChannelCreate addParameter(String key, String value) {
        add(new KeyValueParameter(key, value));
        return this;
    }

}
