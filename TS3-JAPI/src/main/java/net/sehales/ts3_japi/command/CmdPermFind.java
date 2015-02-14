package net.sehales.ts3_japi.command;

import java.util.List;

import net.sehales.ts3_japi.command.parameter.KeyValueParameter;
import net.sehales.ts3_japi.property.PermissionInfoProperty;
import net.sehales.ts3_japi.wrapper.MapWrapper;

public class CmdPermFind extends ArrayResponseCommand {

    private CmdPermFind() {
        super("permfind");
    }

    public CmdPermFind(int permId) {
        this();
        add(new KeyValueParameter("permid", permId));
    }

    public CmdPermFind(String permsId) {
        this();
        add(new KeyValueParameter("permsid", permsId));
    }

    /**
     * Take a look at {@link PermissionInfoProperty} for the meaning of the entries you can get from this <code>List<{@link MapWrapper}></code>
     */
    @Override
    public List<MapWrapper> getResponseWrapper() {
        return response.getWrapperList();
    }

}
