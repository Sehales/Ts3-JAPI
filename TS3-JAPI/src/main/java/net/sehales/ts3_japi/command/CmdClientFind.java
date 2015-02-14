package net.sehales.ts3_japi.command;

import java.util.List;

import net.sehales.ts3_japi.command.parameter.KeyValueParameter;
import net.sehales.ts3_japi.property.ClientProperty;
import net.sehales.ts3_japi.wrapper.MapWrapper;

public class CmdClientFind extends ArrayResponseCommand {

    public CmdClientFind(String pattern) {
        super("clientfind");
        add(new KeyValueParameter("pattern", pattern));
    }

    /**
     * @return a <code>List<{@link MapWrapper}></code> with {@link MapWrapper} which only contain two entries with the following keys:
     *         {@link ClientProperty#CLID} and {@link ClientProperty#CLIENT_NICKNAME}
     */
    @Override
    public List<MapWrapper> getResponseWrapper() {
        return response.getWrapperList();
    }

}
