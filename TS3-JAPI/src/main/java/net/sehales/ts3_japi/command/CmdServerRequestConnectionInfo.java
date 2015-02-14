package net.sehales.ts3_japi.command;

import net.sehales.ts3_japi.wrapper.MapWrapper;

/**
 * @see {@link CmdServerInfo}
 *
 */
public class CmdServerRequestConnectionInfo extends ArrayResponseCommand {

    public CmdServerRequestConnectionInfo() {
        super("serverrequestconnectioninfo");
    }

    /**
     * It returns technically the same fields as "serverinfo", but with partial different names.
     * 
     * Usage of {@link CmdServerInfo} is recommended!
     * 
     * @see {@link CmdServerInfo#getResponseWrapper()}
     */
    @Override
    public MapWrapper getResponseWrapper() {
        return response.getWrapper();
    }
}
