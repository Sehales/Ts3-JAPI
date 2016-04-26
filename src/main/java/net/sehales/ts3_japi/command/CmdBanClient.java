package net.sehales.ts3_japi.command;

import java.util.ArrayList;
import java.util.List;

import net.sehales.ts3_japi.command.parameter.KeyValueParameter;
import net.sehales.ts3_japi.property.BanProperty;

public class CmdBanClient extends ArrayResponseCommand {

    public CmdBanClient(int clientId) {
        super("banclient");
        add(new KeyValueParameter("clid", clientId));
    }

    public CmdBanClient(int clientId, long timeInSeconds) {
        this(clientId);
        add(new KeyValueParameter("time", timeInSeconds));
    }

    public CmdBanClient(int clientId, long timeInSeconds, String banReason) {
        this(clientId, timeInSeconds);
        add(new KeyValueParameter("banreason", banReason));
    }

    public CmdBanClient(int clientId, String banReason) {
        this(clientId);
        add(new KeyValueParameter("banreason", banReason));
    }

    private List<Integer> getBanIds() {
        List<Integer> ids = new ArrayList<>();
        response.getWrapperList().forEach(m -> ids.add(m.getInt(BanProperty.BANID)));
        return ids;
    }

    /**
     * Get a list of all newly created ban ids
     * 
     * @return a list of all newly created ban ids
     */
    @Override
    public List<Integer> getResponseWrapper() {
        return getBanIds();
    }

}
