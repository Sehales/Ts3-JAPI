package net.sehales.ts3_japi.command;

import java.util.List;

import net.sehales.ts3_japi.command.parameter.KeyValueParameter;
import net.sehales.ts3_japi.command.parameter.OptionParameter;
import net.sehales.ts3_japi.property.PermissionProperty;
import net.sehales.ts3_japi.wrapper.MapWrapper;

public class CmdClientPermList extends ArrayResponseCommand {

    public CmdClientPermList(long clientDbId) {
        super("clientpermlist");
        add(new KeyValueParameter("cldbid", clientDbId));
    }

    /**
     * Take a look at {@link PermissionProperty} for possible properties you can get from this <code>List<{@link MapWrapper}></code>
     */
    @Override
    public List<MapWrapper> getResponseWrapper() {
        return response.getWrapperList();
    }

    public CmdClientPermList permsid() {
        add(new OptionParameter("permsid"));
        return this;
    }
}
