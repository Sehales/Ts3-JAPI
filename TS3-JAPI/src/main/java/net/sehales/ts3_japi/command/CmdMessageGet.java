package net.sehales.ts3_japi.command;

import net.sehales.ts3_japi.command.parameter.KeyValueParameter;
import net.sehales.ts3_japi.wrapper.MapWrapper;

public class CmdMessageGet extends ArrayResponseCommand {

    public CmdMessageGet(int msgId) {
        super("messageget");
        add(new KeyValueParameter("msgid", msgId));
    }

    /**
     * @return A {@link MapWrapper} containing entries available via the following keys: {@link }
     */
    @Override
    public MapWrapper getResponseWrapper() {
        return response.getWrapper();
    }
}
