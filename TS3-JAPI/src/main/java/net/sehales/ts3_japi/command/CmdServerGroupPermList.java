package net.sehales.ts3_japi.command;

import java.util.List;

import net.sehales.ts3_japi.command.parameter.KeyValueParameter;
import net.sehales.ts3_japi.command.parameter.OptionParameter;
import net.sehales.ts3_japi.property.PermissionProperty;
import net.sehales.ts3_japi.wrapper.MapWrapper;

public class CmdServerGroupPermList extends ArrayResponseCommand {

    public CmdServerGroupPermList(int serverGroupId) {
        super("servergrouppermlist");
        add(new KeyValueParameter("sgid", serverGroupId));
    }

    /**
     * Take a look at {@link PermissionProperty} for possible properties you can get from this {@link MapWrapper}
     */
    @Override
    public List<MapWrapper> getResponseWrapper() {
        return response.getWrapperList();
    }

    /**
     * @return permission names instead of internal ids
     */
    public CmdServerGroupPermList permsId() {
        add(new OptionParameter("permsid"));
        return this;
    }

}
