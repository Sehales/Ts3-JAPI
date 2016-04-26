package net.sehales.ts3_japi.command;

import net.sehales.ts3_japi.command.parameter.KeyValueParameter;
import net.sehales.ts3_japi.property.ChannelProperty;
import net.sehales.ts3_japi.property.ServerInstanceProperty;

public class CmdChannelEdit extends Command {
    public CmdChannelEdit(int channelId) {
        super("channeledit");
        add(new KeyValueParameter("cid", channelId));
    }

    /**
     * @see #addParameter(ChannelProperty, String)
     */
    public CmdChannelEdit(int channelId, ChannelProperty property, String value) {
        this(channelId);
        addParameter(property, value);
    }

    /**
     * All unchangeable properties passed into it will be ignored
     * 
     * @param property
     * @param value
     * @return
     */
    public CmdChannelEdit addParameter(ChannelProperty property, String value) {
        if (property.isChangeable()) {
            return addParameter(property.toString(), value);
        }
        return this;
    }

    public CmdChannelEdit addParameter(String key, String value) {
        add(new KeyValueParameter(key, value));
        return this;
    }
}
