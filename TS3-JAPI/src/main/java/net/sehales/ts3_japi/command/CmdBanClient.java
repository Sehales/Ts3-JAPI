package net.sehales.ts3_japi.command;

import net.sehales.ts3_japi.command.parameter.KeyValueParameter;

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

}
