package net.sehales.ts3_japi.command;

import java.util.List;

import net.sehales.ts3_japi.command.parameter.OptionParameter;
import net.sehales.ts3_japi.property.ChannelProperty;
import net.sehales.ts3_japi.wrapper.MapWrapper;

public class CmdChannelList extends ArrayResponseCommand {

    public CmdChannelList() {
        super("channellist");
    }

    public CmdChannelList flags() {
        add(new OptionParameter("flags"));
        return this;
    }

    /**
     * Take a look at {@link ChannelProperty} for possible properties you can get from this <code>List<{@link MapWrapper}></code>
     */
    @Override
    public List<MapWrapper> getResponseWrapper() {
        return response.getWrapperList();
    }

    public CmdChannelList icon() {
        add(new OptionParameter("icon"));
        return this;
    }

    public CmdChannelList limits() {
        add(new OptionParameter("limits"));
        return this;
    }

    public CmdChannelList topic() {
        add(new OptionParameter("topic"));
        return this;
    }

    public CmdChannelList voice() {
        add(new OptionParameter("voice"));
        return this;
    }

}
