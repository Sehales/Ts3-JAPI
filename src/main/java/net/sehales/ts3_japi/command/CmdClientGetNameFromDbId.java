package net.sehales.ts3_japi.command;

import net.sehales.ts3_japi.command.parameter.KeyValueParameter;

public class CmdClientGetNameFromDbId extends ArrayResponseCommand {

    public CmdClientGetNameFromDbId(int clientDbId) {
        super("clientgetnamefromdbid");
        add(new KeyValueParameter("cldbid", clientDbId));
    }

    /**
     * This method only returns the "name" entry of the response for other entries, which the response of this command contains, you can use
     * {@link #getResponse()} to get a wrapper for all entries
     * 
     * @return the name of the client with the given db id
     */
    @Override
    public String getResponseWrapper() {
        return response.getWrapper().getString("name");
    }

}
