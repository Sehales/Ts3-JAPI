package net.sehales.ts3_japi.command;

import net.sehales.ts3_japi.property.ClientProperty;
import net.sehales.ts3_japi.property.VirtualServerProperty;
import net.sehales.ts3_japi.wrapper.MapWrapper;

public class CmdWhoAmI extends ArrayResponseCommand {

    public CmdWhoAmI() {
        super("whoami");
    }

    /**
     * The {@link MapWrapper} returned by this method contains entries with the following keys: {@link VirtualServerProperty#VIRTUALSERVER_STATUS},
     * {@link VirtualServerProperty#VIRTUALSERVER_ID}, {@link VirtualServerProperty#VIRTUALSERVER_UNIQUE_IDENTIFER},
     * {@link VirtualServerProperty#VIRTUALSERVER_PORT}, {@link ClientProperty#CLIENT_ID}, {@link ClientProperty#CLIENT_CHANNEL_ID},
     * {@link ClientProperty#CLIENT_NICKNAME}, {@link ClientProperty#CLIENT_DATABASE_ID}, {@link ClientProperty#CLIENT_LOGIN_NAME},
     * {@link ClientProperty#CLIENT_UNIQUE_IDENTIFIER}, {@link ClientProperty#CLIENT_ORIGIN_SERVER_ID}
     */
    @Override
    public MapWrapper getResponseWrapper() {
        return response.getWrapper();
    }
}
