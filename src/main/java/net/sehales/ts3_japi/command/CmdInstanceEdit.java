package net.sehales.ts3_japi.command;

import net.sehales.ts3_japi.command.parameter.KeyValueParameter;
import net.sehales.ts3_japi.property.ServerInstanceProperty;

public class CmdInstanceEdit extends Command {

    public CmdInstanceEdit() {
        super("instanceedit");
    }

    /**
     * @see #addParameter(ServerInstanceProperty, int)
     */
    public CmdInstanceEdit(ServerInstanceProperty property, int value) {
        this();
        addParameter(property, value);
    }

    /**
     * @see #addParameter(ServerInstanceProperty, String)
     */
    public CmdInstanceEdit(ServerInstanceProperty property, String value) {
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
    public CmdInstanceEdit addParameter(ServerInstanceProperty property, int value) {
        if (property.isChangeable()) {
            return addParameter(property.toString(), value);
        }
        return this;
    }

    /**
     * All unchangeable properties passed into it will be ignored
     * 
     * @param property
     * @param value
     * @return
     */
    public CmdInstanceEdit addParameter(ServerInstanceProperty property, String value) {
        if (property.isChangeable()) {
            return addParameter(property.toString(), value);
        }
        return this;
    }

    public CmdInstanceEdit addParameter(String key, int value) {
        add(new KeyValueParameter(key, value));
        return this;
    }

    public CmdInstanceEdit addParameter(String key, String value) {
        add(new KeyValueParameter(key, value));
        return this;
    }
}
