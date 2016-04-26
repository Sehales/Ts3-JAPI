package net.sehales.ts3_japi.command;

import net.sehales.ts3_japi.command.parameter.KeyValueParameter;
import net.sehales.ts3_japi.property.ClientProperty;
import net.sehales.ts3_japi.property.ServerInstanceProperty;

public class CmdClientUpdate extends Command {

    public CmdClientUpdate() {
        super("clientupdate");
    }

    /**
     * @see #addParameter(ClientProperty, String)
     */
    public CmdClientUpdate(ClientProperty property, String value) {
        this();
        addParameter(property, value);
    }

    /**
     * All unchangeable properties passed into it will be ignored
     * 
     * @param property
     * @param value
     * @return
     */
    public CmdClientUpdate addParameter(ClientProperty property, String value) {
        if (property.isChangeable()) {
            return addParameter(property.toString(), value);
        }
        return this;
    }

    public CmdClientUpdate addParameter(String key, String value) {
        add(new KeyValueParameter(key, value));
        return this;
    }

}
