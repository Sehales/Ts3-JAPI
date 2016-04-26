package net.sehales.ts3_japi.command;

import net.sehales.ts3_japi.command.parameter.KeyValueParameter;
import net.sehales.ts3_japi.property.ServerIdGetByPortProperty;

public class CmdServerIdGetByPort extends ArrayResponseCommand {

    public CmdServerIdGetByPort(int port) {
        super("serveridgetbyport");
        add(new KeyValueParameter("virtualserver_port", port));
    }

    /**
     * Due to the circumstance that this command has only one key value pair in it's response it directly returns that value
     * 
     * @return the integer returned by {@link ServerIdGetByPortProperty#SERVER_ID}
     */
    @Override
    public Integer getResponseWrapper() {
        return response.getWrapper().getInt(ServerIdGetByPortProperty.SERVER_ID);
    }
}
