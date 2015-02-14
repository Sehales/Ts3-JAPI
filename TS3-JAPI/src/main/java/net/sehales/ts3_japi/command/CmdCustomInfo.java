package net.sehales.ts3_japi.command;

import java.util.List;

import net.sehales.ts3_japi.command.parameter.KeyValueParameter;
import net.sehales.ts3_japi.property.CustomProperty;
import net.sehales.ts3_japi.wrapper.MapWrapper;

public class CmdCustomInfo extends ArrayResponseCommand {

    public CmdCustomInfo(long clientDbId) {
        super("custominfo");
        add(new KeyValueParameter("cldbid", clientDbId));
    }

    /**
     * @return a <code>List<{@link MapWrapper}></code> with {@link MapWrapper} take a look at {@link CustomProperty} for possible properties you can
     *         get from it
     * 
     */
    @Override
    public List<MapWrapper> getResponseWrapper() {
        return response.getWrapperList();
    }

}
