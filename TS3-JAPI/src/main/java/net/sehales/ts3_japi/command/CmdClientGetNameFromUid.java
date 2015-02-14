package net.sehales.ts3_japi.command;

import net.sehales.ts3_japi.command.parameter.KeyValueParameter;

public class CmdClientGetNameFromUid extends ArrayResponseCommand {
    public CmdClientGetNameFromUid(String clientUid) {
        super("clientgetnamefromuid");
        add(new KeyValueParameter("cluid", clientUid));
    }

    /**
     * This method only returns the "name" entry of the response for other entries, which the response of this command contains, you can use
     * {@link #getResponse()} to get a wrapper for all entries
     * 
     * @return the name of the client with the given uid
     */
    @Override
    public String getResponseWrapper() {
        return response.getWrapper().getString("name");
    }
}
