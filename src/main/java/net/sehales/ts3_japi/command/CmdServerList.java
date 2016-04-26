package net.sehales.ts3_japi.command;

import java.util.List;

import net.sehales.ts3_japi.command.parameter.OptionParameter;
import net.sehales.ts3_japi.property.ServerListProperty;
import net.sehales.ts3_japi.wrapper.MapWrapper;

public class CmdServerList extends ArrayResponseCommand {

    public CmdServerList() {
        super("serverlist");
    }

    public CmdServerList all() {
        add(new OptionParameter("all"));
        return this;
    }

    /**
     * Take a look at {@link ServerListProperty} for possible properties you can get from this {@link MapWrapper}
     */
    @Override
    public List<MapWrapper> getResponseWrapper() {
        return response.getWrapperList();
    }

    public CmdServerList onlyOffline() {
        add(new OptionParameter("onlyoffline"));
        return this;
    }

    /**
     * the '_' is appended to this method's name due to the circumstance that "short" is a reserved keyword
     * 
     * @return
     */
    public CmdServerList short_() {
        add(new OptionParameter("short"));
        return this;
    }

    public CmdServerList uid() {
        add(new OptionParameter("uid"));
        return this;
    }

}
