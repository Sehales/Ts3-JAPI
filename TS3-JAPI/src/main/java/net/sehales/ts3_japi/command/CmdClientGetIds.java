package net.sehales.ts3_japi.command;

import java.util.ArrayList;
import java.util.List;

import net.sehales.ts3_japi.command.parameter.KeyValueParameter;
import net.sehales.ts3_japi.property.ClientProperty;

public class CmdClientGetIds extends ArrayResponseCommand {

    public CmdClientGetIds(String clientUid) {
        super("clientgetids");
        add(new KeyValueParameter("cluid", clientUid));
    }

    private List<Integer> getIds() {
        List<Integer> ids = new ArrayList<>();
        response.getWrapperList().forEach(m -> ids.add(m.getInt(ClientProperty.CLID)));
        return ids;
    }

    /**
     * @return a list of all client ids of currently connected clients for the given uid
     */
    @Override
    public List<Integer> getResponseWrapper() {
        return getIds();
    }

}
