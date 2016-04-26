package net.sehales.ts3_japi.command;

import net.sehales.ts3_japi.command.parameter.KeyValueParameter;
import net.sehales.ts3_japi.property.LogLevel;

public class CmdLogAdd extends Command {

    public CmdLogAdd(int logLevel, String msg) {
        super("logadd");
        add(new KeyValueParameter("loglevel", logLevel));
        add(new KeyValueParameter("logmsg", msg));
    }

    public CmdLogAdd(LogLevel lvl, String msg) {
        this(lvl.getIndex(), msg);
    }

}
