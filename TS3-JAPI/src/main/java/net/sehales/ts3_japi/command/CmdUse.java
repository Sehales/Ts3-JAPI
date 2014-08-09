package net.sehales.ts3_japi.command;

import net.sehales.ts3_japi.command.parameter.KeyValueParameter;
import net.sehales.ts3_japi.command.parameter.OptionParameter;
import net.sehales.ts3_japi.command.parameter.RawParameter;
import net.sehales.ts3_japi.wrapper.Wrapper;

public class CmdUse extends Command {

    public CmdUse() {
        super("use");
    }

    public CmdUse(int id) {
        this();
        add(new RawParameter(id + ""));
    }

    @Override
    public Wrapper getResponseWrapper() {
        return null;
    }

    public CmdUse virtual() {
        add(new OptionParameter("-virtual"));
        return this;
    }

    public CmdUse withId(int id) {
        add(new KeyValueParameter("sid", id + ""));
        return this;
    }

    public CmdUse withPort(int port) {
        add(new KeyValueParameter("port", port + ""));
        return this;
    }

}
