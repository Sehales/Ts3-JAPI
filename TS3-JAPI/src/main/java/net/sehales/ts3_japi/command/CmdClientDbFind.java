package net.sehales.ts3_japi.command;

import net.sehales.ts3_japi.command.parameter.KeyValueParameter;
import net.sehales.ts3_japi.command.parameter.OptionParameter;

public class CmdClientDbFind extends ArrayResponseCommand {

    public CmdClientDbFind(String pattern) {
        super("clientdbfind");
        add(new KeyValueParameter("pattern", pattern));
    }

    public CmdClientDbFind uid() {
        add(new OptionParameter("uid"));
        return this;
    }

}
