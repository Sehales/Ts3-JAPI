package net.sehales.ts3_japi.command;

import java.util.List;

import net.sehales.ts3_japi.command.parameter.KeyValueParameter;
import net.sehales.ts3_japi.property.ComplainProperty;
import net.sehales.ts3_japi.wrapper.MapWrapper;

public class CmdComplainList extends ArrayResponseCommand {
    public CmdComplainList() {
        super("complainlist");
    }

    public CmdComplainList(int targetClientDbId) {
        this();
        add(new KeyValueParameter("tcldbid", targetClientDbId));
    }

    /**
     * Take a look at {@link ComplainProperty} for the properties you can get from this <code>List<{@link MapWrapper}></code>
     */
    @Override
    public List<MapWrapper> getResponseWrapper() {
        return response.getWrapperList();
    }

}
