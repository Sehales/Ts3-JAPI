package net.sehales.ts3_japi.command;

import net.sehales.ts3_japi.command.parameter.KeyValueParameter;
import net.sehales.ts3_japi.property.TextMessageTargetMode;

public class CmdSendTextMessage extends Command {

    public CmdSendTextMessage(int targetMode, int targetId, String msg) {
        super("sendtextmessage");
        add(new KeyValueParameter("targetmode", targetMode));
        add(new KeyValueParameter("target", targetId));
        add(new KeyValueParameter("msg", msg));
    }

    public CmdSendTextMessage(TextMessageTargetMode mode, int targetId, String msg) {
        this(mode.getIndex(), targetId, msg);
    }
}
