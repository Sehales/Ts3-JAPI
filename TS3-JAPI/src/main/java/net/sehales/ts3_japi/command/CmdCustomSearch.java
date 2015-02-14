package net.sehales.ts3_japi.command;

import java.util.List;

import net.sehales.ts3_japi.command.parameter.KeyValueParameter;
import net.sehales.ts3_japi.property.ClientProperty;
import net.sehales.ts3_japi.property.CustomProperty;
import net.sehales.ts3_japi.wrapper.MapWrapper;

public class CmdCustomSearch extends ArrayResponseCommand {

    public CmdCustomSearch(String ident, String pattern) {
        super("customsearch");
        add(new KeyValueParameter("ident", ident));
        add(new KeyValueParameter("pattern", pattern));
    }

    /**
     * @return a <code>List<{@link MapWrapper}></code> with {@link MapWrapper} take a look at {@link CustomProperty} for possible properties you can
     *         get from it It also always returns the clients database id with the key {@link ClientProperty#CLDBID}
     */
    @Override
    public List<MapWrapper> getResponseWrapper() {
        return response.getWrapperList();
    }

}
