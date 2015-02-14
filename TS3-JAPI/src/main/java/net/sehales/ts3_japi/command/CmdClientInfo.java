package net.sehales.ts3_japi.command;

import net.sehales.ts3_japi.command.parameter.KeyValueParameter;
import net.sehales.ts3_japi.property.ClientProperty;
import net.sehales.ts3_japi.wrapper.MapWrapper;

public class CmdClientInfo extends ArrayResponseCommand {

    public CmdClientInfo(int clientId) {
        super("clientinfo");
        add(new KeyValueParameter("clid", clientId));
    }

    /**
     * Take a look at {@link ClientProperty} for possible properties you can get from this {@link MapWrapper}
     */
    @Override
    public Object getResponseWrapper() {
        return response.getWrapper();
    }

}
