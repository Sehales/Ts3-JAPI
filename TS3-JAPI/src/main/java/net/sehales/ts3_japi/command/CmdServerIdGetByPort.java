package net.sehales.ts3_japi.command;

import net.sehales.ts3_japi.command.parameter.RawParameter;

public class CmdServerIdGetByPort extends ArrayResponseCommand {

    public CmdServerIdGetByPort(int port) {
        super("serveridgetbyport");
        add(new RawParameter(port));
    }

}
