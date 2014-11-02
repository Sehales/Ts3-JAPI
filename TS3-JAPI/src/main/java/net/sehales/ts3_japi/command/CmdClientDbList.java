package net.sehales.ts3_japi.command;

import net.sehales.ts3_japi.command.parameter.KeyValueParameter;
import net.sehales.ts3_japi.command.parameter.OptionParameter;

public class CmdClientDbList extends ArrayResponseCommand {

    public CmdClientDbList() {
        super("clientdblist");
    }

    public CmdClientDbList count() {
        add(new OptionParameter("count"));
        return this;
    }

    public CmdClientDbList duration(long limit) {
        add(new KeyValueParameter("duration", limit));
        return this;
    }

    /**
     * alias for duration because of that not well chosen parameter name
     * 
     * @param limit
     * @return
     */
    public CmdClientDbList limit(long limit) {
        return duration(limit);
    }

    /**
     * starts at 0
     * 
     * @param offset
     * @return
     */
    public CmdClientDbList start(long offset) {
        add(new KeyValueParameter("start", offset));
        return this;
    }

}
