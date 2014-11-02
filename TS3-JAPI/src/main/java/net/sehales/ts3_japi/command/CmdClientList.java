package net.sehales.ts3_japi.command;

import net.sehales.ts3_japi.command.parameter.OptionParameter;

public class CmdClientList extends ArrayResponseCommand {

    public CmdClientList() {
        super("clientlist");
    }

    public CmdClientList away() {
        add(new OptionParameter("away"));
        return this;
    }

    public CmdClientList country() {
        add(new OptionParameter("country"));
        return this;
    }

    public CmdClientList groups() {
        add(new OptionParameter("groups"));
        return this;
    }

    public CmdClientList icon() {
        add(new OptionParameter("icon"));
        return this;
    }

    public CmdClientList info() {
        add(new OptionParameter("info"));
        return this;
    }

    public CmdClientList times() {
        add(new OptionParameter("times"));
        return this;
    }

    public CmdClientList uid() {
        add(new OptionParameter("uid"));
        return this;
    }

    public CmdClientList voice() {
        add(new OptionParameter("voice"));
        return this;
    }

}
