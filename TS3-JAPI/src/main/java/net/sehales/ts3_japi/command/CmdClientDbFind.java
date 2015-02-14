package net.sehales.ts3_japi.command;

import java.util.ArrayList;
import java.util.List;

import net.sehales.ts3_japi.command.parameter.KeyValueParameter;
import net.sehales.ts3_japi.command.parameter.OptionParameter;
import net.sehales.ts3_japi.property.ClientProperty;

public class CmdClientDbFind extends ArrayResponseCommand {

    public CmdClientDbFind(String pattern) {
        super("clientdbfind");
        add(new KeyValueParameter("pattern", pattern));
    }

    private List<Long> getDBIds() {
        List<Long> ids = new ArrayList<>();
        response.getWrapperList().forEach(m -> ids.add(m.getLong(ClientProperty.CLDBID)));
        return ids;
    }

    /**
     * @return a list of database ids with a matching pattern
     */
    @Override
    public List<Long> getResponseWrapper() {
        return getDBIds();
    }

    public CmdClientDbFind uid() {
        add(new OptionParameter("uid"));
        return this;
    }

}
