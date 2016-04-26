package net.sehales.ts3_japi.command;

import java.util.List;

import net.sehales.ts3_japi.command.parameter.KeyValueParameter;
import net.sehales.ts3_japi.command.parameter.OptionParameter;
import net.sehales.ts3_japi.property.ClientProperty;
import net.sehales.ts3_japi.wrapper.MapWrapper;

public class CmdServerGroupClientList extends ArrayResponseCommand {

    public CmdServerGroupClientList(int serverGroupId) {
        super("servergroupclientlist");
        add(new KeyValueParameter("sgid", serverGroupId));
    }

    /**
     * @return a <code>List<{@link MapWrapper}></code> with {@link MapWrapper} - objects with only one entry: {@link ClientProperty#CLDBID}
     * 
     * @see #names()
     */
    @Override
    public List<MapWrapper> getResponseWrapper() {
        return response.getWrapperList();
    }

    /**
     * When adding this option the command's response additionally contains {@link ClientProperty#CLIENT_NICKNAME} and
     * {@link ClientProperty#CLIENT_UNIQUE_IDENTIFIER}
     * 
     * @see #getResponseWrapper()
     */
    public CmdServerGroupClientList names() {
        add(new OptionParameter("names"));
        return this;
    }
}
