package net.sehales.ts3_japi.command;

import net.sehales.ts3_japi.command.parameter.KeyValueParameter;
import net.sehales.ts3_japi.property.VirtualServerProperty;

public class CmdServerCreate extends ArrayResponseCommand {

    public CmdServerCreate() {
        super("servercreate");
    }

    public CmdServerCreate addParameter(String key, String value) {
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
    public CmdServerCreate addParameter(VirtualServerProperty property, String value) {
        if (property.isChangeable()) {
            return addParameter(property.getName(), value);
        }
        return this;
    }

}
