package net.sehales.ts3_japi.command;

import net.sehales.ts3_japi.command.parameter.KeyValueParameter;
import net.sehales.ts3_japi.command.parameter.OptionParameter;

public class CmdClientDbList extends Command {

    public CmdClientDbList() {
        super("clientdblist");
    }

    public CmdClientDbList count() {
        add(new OptionParameter("count"));
        return this;
    }

    public CmdClientDbList duration(long limit) {
        add(new KeyValueParameter("duration", "" + limit));
        return this;
    }

    public CmdClientDbList start(long offset) {
        add(new KeyValueParameter("start", "" + offset));
        return this;
    }

}
