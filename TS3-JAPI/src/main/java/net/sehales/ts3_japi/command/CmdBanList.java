package net.sehales.ts3_japi.command;

import java.util.List;

import net.sehales.ts3_japi.property.BanProperty;
import net.sehales.ts3_japi.wrapper.MapWrapper;

public class CmdBanList extends ArrayResponseCommand {

    public CmdBanList() {
        super("banlist");
    }

    /**
     * Take a look at {@link BanProperty} for possible properties you can get from this {@link MapWrapper}
     */
    @Override
    public List<MapWrapper> getResponseWrapper() {
        return response.getWrapperList();
    }

}
