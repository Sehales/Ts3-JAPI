package net.sehales.ts3_japi.command;

import java.util.List;

import net.sehales.ts3_japi.property.TokenProperty;
import net.sehales.ts3_japi.wrapper.MapWrapper;

public class CmdPrivilegeKeyList extends ArrayResponseCommand {

    public CmdPrivilegeKeyList() {
        super("privilegekeylist");
    }

    /**
     * Take a look at {@link TokenProperty} for possible properties you can get from this <code>List<{@link MapWrapper}></code>
     */
    @Override
    public List<MapWrapper> getResponseWrapper() {
        return response.getWrapperList();
    }

}
