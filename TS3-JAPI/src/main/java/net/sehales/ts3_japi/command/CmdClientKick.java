package net.sehales.ts3_japi.command;

import net.sehales.ts3_japi.command.parameter.ArrayParameter;
import net.sehales.ts3_japi.command.parameter.KeyValueParameter;
import net.sehales.ts3_japi.property.KickType;

public class CmdClientKick extends Command {

    private ArrayParameter array = new ArrayParameter();

    // named the enum to KickType because of that less saying default name
    public CmdClientKick(KickType reasonId) {
        super("clientkick");
        add(new KeyValueParameter("reasonid", reasonId.getIndex()));
    }

    @Override
    public String buildString() {
        add(array);
        return super.buildString();
    }

    public CmdClientKick clientId(int clientId) {
        array.add(new KeyValueParameter("clid", clientId));
        return this;
    }

    public CmdClientKick withMessage(String msg) {
        add(new KeyValueParameter("reasonmsg", msg));
        return this;
    }

}
