package net.sehales.ts3_japi.command;

import net.sehales.ts3_japi.command.response.ArrayResponse;
import net.sehales.ts3_japi.wrapper.VersionInfo;

public class CmdVersion extends Command {

    public CmdVersion() {
        super("version");
    }

    @Override
    public VersionInfo getResponseWrapper() {
        return new VersionInfo(((ArrayResponse) response).getResponseData().get(0));
    }

}
