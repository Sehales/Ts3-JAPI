package net.sehales.ts3_japi.command;

import java.util.List;

import net.sehales.ts3_japi.command.parameter.KeyValueParameter;
import net.sehales.ts3_japi.command.parameter.OptionParameter;
import net.sehales.ts3_japi.property.ClientProperty;
import net.sehales.ts3_japi.wrapper.MapWrapper;

public class CmdClientDbList extends ArrayResponseCommand {

    public CmdClientDbList() {
        super("clientdblist");
    }

    public CmdClientDbList count() {
        add(new OptionParameter("count"));
        return this;
    }

    public CmdClientDbList duration(long limit) {
        add(new KeyValueParameter("duration", limit));
        return this;
    }

    /**
     * Take a look at {@link ClientProperty} for possible properties you can get from this {@link MapWrapper}
     */
    @Override
    public List<MapWrapper> getResponseWrapper() {
        return response.getWrapperList();
    }

    /**
     * alias for duration because of that not well chosen parameter name
     * 
     * @param limit
     * @return
     */
    public CmdClientDbList limit(long limit) {
        return duration(limit);
    }

    /**
     * starts at 0
     * 
     * @param offset
     * @return
     */
    public CmdClientDbList start(long offset) {
        add(new KeyValueParameter("start", offset));
        return this;
    }

}
