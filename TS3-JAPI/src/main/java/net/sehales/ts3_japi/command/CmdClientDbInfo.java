package net.sehales.ts3_japi.command;

import net.sehales.ts3_japi.command.parameter.KeyValueParameter;
import net.sehales.ts3_japi.property.ClientProperty;
import net.sehales.ts3_japi.wrapper.MapWrapper;

public class CmdClientDbInfo extends ArrayResponseCommand {

    public CmdClientDbInfo(long clientDbId) {
        super("clientdbinfo");
        add(new KeyValueParameter("cldbid", clientDbId));
    }

    /**
     * Take a look at {@link ClientProperty} for possible properties you can get from this {@link MapWrapper}
     */
    @Override
    public MapWrapper getResponseWrapper() {
        return response.getWrapper();
    }

}
