package net.sehales.ts3_japi.command;

import net.sehales.ts3_japi.property.TokenProperty;

public class CmdPermReset extends ArrayResponseCommand {

    public CmdPermReset() {
        super("permreset");
    }

    /**
     * @return A token used for getting the "Server Admin" group on the resetted ts server
     */
    @Override
    public String getResponseWrapper() {
        return response.getWrapper().getString(TokenProperty.TOKEN);
    }

}
