package net.sehales.ts3_japi.command;

import net.sehales.ts3_japi.command.parameter.KeyValueParameter;
import net.sehales.ts3_japi.property.BanProperty;

public class CmdBanAdd extends ArrayResponseCommand {

    public CmdBanAdd() {
        super("banadd");
    }

    /**
     * @return the ban id for this ban
     */
    @Override
    public Integer getResponseWrapper() {
        return response.getWrapper().getInt(BanProperty.BANID);
    }

    public CmdBanAdd withIp(String regexp) {
        add(new KeyValueParameter("ip", regexp));
        return this;
    }

    public CmdBanAdd withName(String regexp) {
        add(new KeyValueParameter("name", regexp));
        return this;
    }

    public CmdBanAdd withReason(String message) {
        add(new KeyValueParameter("banreason", message));
        return this;
    }

    public CmdBanAdd withTime(long timeInSeconds) {
        add(new KeyValueParameter("time", timeInSeconds));
        return this;
    }

    public CmdBanAdd withUid(String clientUid) {
        add(new KeyValueParameter("uid", clientUid));
        return this;
    }

}
