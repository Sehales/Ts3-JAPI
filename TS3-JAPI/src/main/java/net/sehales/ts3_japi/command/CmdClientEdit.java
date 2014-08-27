package net.sehales.ts3_japi.command;

import net.sehales.ts3_japi.command.parameter.KeyValueParameter;
import net.sehales.ts3_japi.property.ClientProperty;
import net.sehales.ts3_japi.property.ServerInstanceProperty;

public class CmdClientEdit extends Command {

    public CmdClientEdit(int clientId) {
        super("clientedit");
        add(new KeyValueParameter("clid", clientId));
    }

    /**
     * @see #addParameter(ServerInstanceProperty, String)
     */
    public CmdClientEdit(int clientId, ClientProperty property, String value) {
        this(clientId);
        addParameter(property, value);
    }

    /**
     * All unchangeable properties passed into it will be ignored
     * 
     * @param property
     * @param value
     * @return
     */
    public CmdClientEdit addParameter(ClientProperty property, String value) {
        if (property.isChangeable()) {
            return addParameter(property.getName(), value);
        }
        return this;
    }

    public CmdClientEdit addParameter(String key, String value) {
        add(new KeyValueParameter(key, value));
        return this;
    }

}
