package net.sehales.ts3_japi.command;

import net.sehales.ts3_japi.command.parameter.KeyValueParameter;
import net.sehales.ts3_japi.property.ServerInstanceProperty;
import net.sehales.ts3_japi.wrapper.Wrapper;

public class CmdInstanceEdit extends Command {

    public CmdInstanceEdit() {
        super("instanceedit");
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
    public CmdInstanceEdit addParameter(ServerInstanceProperty property, String value) {
        if (property.isChangeable()) {
            return addParameter(property.getName(), value);
        }
        return this;
    }

    public CmdInstanceEdit addParameter(String key, String value) {
        add(new KeyValueParameter(key, value));
        return this;
    }

    @Override
    public Wrapper getResponseWrapper() {
        return null;
    }

}
