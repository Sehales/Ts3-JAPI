package net.sehales.ts3_japi.command;

import net.sehales.ts3_japi.command.parameter.KeyValueParameter;
import net.sehales.ts3_japi.property.PermissionProperty;

public class CmdPermIdGetByName extends ArrayResponseCommand {

    public CmdPermIdGetByName(String permsId) {
        super("permidgetbyname");
        add(new KeyValueParameter("permsid", permsId));
    }

    /**
     * the response actually also returns the permsid, but this simple response wrapper will only return the permid
     */
    @Override
    public Integer getResponseWrapper() {
        return response.getWrapper().getInt(PermissionProperty.PERMID);
    }

}
