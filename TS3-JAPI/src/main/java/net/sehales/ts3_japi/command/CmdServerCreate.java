package net.sehales.ts3_japi.command;

import net.sehales.ts3_japi.command.parameter.KeyValueParameter;
import net.sehales.ts3_japi.property.ServerCreateProperty;
import net.sehales.ts3_japi.property.VirtualServerProperty;
import net.sehales.ts3_japi.wrapper.MapWrapper;

public class CmdServerCreate extends ArrayResponseCommand {

    public CmdServerCreate() {
        super("servercreate");
    }

    public CmdServerCreate addParameter(String key, int value) {
        add(new KeyValueParameter(key, value));
        return this;
    }

    public CmdServerCreate addParameter(String key, long value) {
        add(new KeyValueParameter(key, value));
        return this;
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
    public CmdServerCreate addParameter(VirtualServerProperty property, int value) {
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
    public CmdServerCreate addParameter(VirtualServerProperty property, long value) {
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
    public CmdServerCreate addParameter(VirtualServerProperty property, String value) {
        if (property.isChangeable()) {
            return addParameter(property.toString(), value);
        }
        return this;
    }

    /**
     * Take a look at {@link ServerCreateProperty} for possible properties you can get from this {@link MapWrapper}
     */
    @Override
    public MapWrapper getResponseWrapper() {
        return response.getWrapper();
    }

}
