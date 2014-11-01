package net.sehales.ts3_japi.command;

import net.sehales.ts3_japi.QueryUtils;
import net.sehales.ts3_japi.command.parameter.KeyValueParameter;

public class CmdFtStop extends Command {

    public CmdFtStop(int serverFileTransferId, boolean delete) {
        super("ftstop");
        add(new KeyValueParameter("serverftfid", serverFileTransferId));
        add(new KeyValueParameter("delete", QueryUtils.toInt(delete)));
    }

}
