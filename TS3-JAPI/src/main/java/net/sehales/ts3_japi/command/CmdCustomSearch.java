package net.sehales.ts3_japi.command;

import net.sehales.ts3_japi.command.parameter.KeyValueParameter;

public class CmdCustomSearch extends Command {

    public CmdCustomSearch(String ident, String pattern) {
        super("customsearch");
        add(new KeyValueParameter("ident", ident));
        add(new KeyValueParameter("pattern", pattern));
    }

}
