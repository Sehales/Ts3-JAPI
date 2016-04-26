package net.sehales.ts3_japi.command;

import java.util.List;

import net.sehales.ts3_japi.command.parameter.KeyValueParameter;
import net.sehales.ts3_japi.property.ClientProperty;
import net.sehales.ts3_japi.property.GroupProperty;
import net.sehales.ts3_japi.wrapper.MapWrapper;

public class CmdServerGroupsByClientId extends ArrayResponseCommand {

    public CmdServerGroupsByClientId(int clientDbId) {
        super("servergroupsbyclientid");
        add(new KeyValueParameter("cldbid", clientDbId));
    }

    /**
     * @return a <code>List<{@link MapWrapper}> which only contains {@link MapWrapper} - objects with the following three keys:
     * 
     * {@link GroupProperty#NAME}, {@link GroupProperty#SGID} and {@link ClientProperty#CLDBID}
     */
    @Override
    public List<MapWrapper> getResponseWrapper() {
        return response.getWrapperList();
    }

}
