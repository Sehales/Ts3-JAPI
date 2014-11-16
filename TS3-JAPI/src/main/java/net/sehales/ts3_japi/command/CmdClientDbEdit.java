package net.sehales.ts3_japi.command;

import net.sehales.ts3_japi.command.parameter.KeyValueParameter;
import net.sehales.ts3_japi.property.ClientProperty;
import net.sehales.ts3_japi.property.ServerInstanceProperty;

public class CmdClientDbEdit extends Command {

    public CmdClientDbEdit(int clientDbId) {
        super("clientdbedit");
        add(new KeyValueParameter("cldbid", clientDbId));
    }

    /**
     * @see #addParameter(ServerInstanceProperty, String)
     */
    public CmdClientDbEdit(int clientDbId, ClientProperty property, String value) {
        this(clientDbId);
        addParameter(property, value);
    }

    /**
     * All unchangeable properties passed into it will be ignored
     * 
     * @param property
     * @param value
     * @return
     */
    public CmdClientDbEdit addParameter(ClientProperty property, String value) {
        if (property.isChangeable()) {
            return addParameter(property.toString(), value);
        }
        return this;
    }

    public CmdClientDbEdit addParameter(String key, String value) {
        add(new KeyValueParameter(key, value));
        return this;
    }
}
