package net.sehales.ts3_japi.command;

import net.sehales.ts3_japi.command.parameter.KeyValueParameter;
import net.sehales.ts3_japi.property.ClientProperty;

public class CmdClientGetDbIdFromUid extends ArrayResponseCommand {

    public CmdClientGetDbIdFromUid(String clientUid) {
        super("clientgetdbidfromuid");
        add(new KeyValueParameter("cluid", clientUid));
    }

    /**
     * @return the client database id for the given uid
     */
    @Override
    public Long getResponseWrapper() {
        return response.getWrapper().getLong(ClientProperty.CLDBID);
    }

}
