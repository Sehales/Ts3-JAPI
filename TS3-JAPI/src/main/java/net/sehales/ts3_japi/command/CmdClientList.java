package net.sehales.ts3_japi.command;

import java.util.List;

import net.sehales.ts3_japi.command.parameter.OptionParameter;
import net.sehales.ts3_japi.property.ClientProperty;
import net.sehales.ts3_japi.wrapper.MapWrapper;

public class CmdClientList extends ArrayResponseCommand {

    public CmdClientList() {
        super("clientlist");
    }

    public CmdClientList away() {
        add(new OptionParameter("away"));
        return this;
    }

    public CmdClientList country() {
        add(new OptionParameter("country"));
        return this;
    }

    /**
     * Take a look at {@link ClientProperty} for possible properties you can get from this <code>List<{@link MapWrapper}></code>
     */
    @Override
    public List<MapWrapper> getResponseWrapper() {
        return response.getWrapperList();
    }

    public CmdClientList groups() {
        add(new OptionParameter("groups"));
        return this;
    }

    public CmdClientList icon() {
        add(new OptionParameter("icon"));
        return this;
    }

    public CmdClientList info() {
        add(new OptionParameter("info"));
        return this;
    }

    public CmdClientList times() {
        add(new OptionParameter("times"));
        return this;
    }

    public CmdClientList uid() {
        add(new OptionParameter("uid"));
        return this;
    }

    public CmdClientList voice() {
        add(new OptionParameter("voice"));
        return this;
    }

}
