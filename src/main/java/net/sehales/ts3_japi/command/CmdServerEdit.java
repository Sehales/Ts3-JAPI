package net.sehales.ts3_japi.command;

import net.sehales.ts3_japi.command.parameter.KeyValueParameter;
import net.sehales.ts3_japi.property.ServerInstanceProperty;
import net.sehales.ts3_japi.property.VirtualServerProperty;

public class CmdServerEdit extends Command {

    public CmdServerEdit() {
        super("serveredit");
    }

    /**
     * @see #addParameter(VirtualServerProperty, String)
     */
    public CmdServerEdit(VirtualServerProperty property, String value) {
        this();
        addParameter(property, value);
    }

    public CmdServerEdit addParameter(String key, String value) {
        add(new KeyValueParameter(key, value));
        return this;
    }

    /**
     * All unchangeable properties passed into it will be ignored
     * 
     * @param property
     * @param value
     * @return
     */
    public CmdServerEdit addParameter(VirtualServerProperty property, String value) {
        if (property.isChangeable()) {
            return addParameter(property.toString(), value);
        }
        return this;
    }
}
