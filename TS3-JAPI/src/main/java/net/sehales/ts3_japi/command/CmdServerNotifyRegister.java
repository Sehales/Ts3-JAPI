package net.sehales.ts3_japi.command;

import net.sehales.ts3_japi.command.parameter.KeyValueParameter;
import net.sehales.ts3_japi.property.ServerEventType;

public class CmdServerNotifyRegister extends Command {

    public CmdServerNotifyRegister(ServerEventType event) {
        this(event.getName());
    }

    public CmdServerNotifyRegister(ServerEventType event, int channelId) {
        this(event.getName(), channelId);
    }

    public CmdServerNotifyRegister(String event) {
        super("servernotifyregister");
        add(new KeyValueParameter("event", event));
    }

    public CmdServerNotifyRegister(String event, int channelId) {
        this(event);
        add(new KeyValueParameter("id", channelId));
    }

}
