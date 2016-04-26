package net.sehales.ts3_japi.command;

import net.sehales.ts3_japi.command.parameter.ArrayParameter;
import net.sehales.ts3_japi.command.parameter.KeyValueParameter;
import net.sehales.ts3_japi.property.PermissionProperty;
import net.sehales.ts3_japi.wrapper.MapWrapper;

public class CmdPermGet extends ArrayResponseCommand {
    private ArrayParameter array = new ArrayParameter();

    private CmdPermGet() {
        super("permget");
    }

    public CmdPermGet(int permId) {
        this();
        add(new KeyValueParameter("permid", permId));
    }

    public CmdPermGet(String permsId) {
        this();
        add(new KeyValueParameter("permsid", permsId));
    }

    @Override
    public String buildString() {
        add(array);
        return super.buildString();
    }

    /**
     * @return A {@link MapWrapper} containing entries available over the following keys: {@link PermissionProperty#PERMID},
     *         {@link PermissionProperty#PERMSID} and {@link PermissionProperty#PERMVALUE}
     */
    @Override
    public MapWrapper getResponseWrapper() {
        return response.getWrapper();
    }

}
