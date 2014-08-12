package net.sehales.ts3_japi.command;

import net.sehales.ts3_japi.QueryUtils;
import net.sehales.ts3_japi.command.parameter.KeyValueParameter;

public class CmdLogView extends Command {

    public CmdLogView() {
        super("logview");
    }

    public CmdLogView(int lines, boolean isReverse, boolean useInstance, long beginPos) {
        this();
        lines(lines);
        reverse(isReverse);
        instance(useInstance);
        beginPos(beginPos);
    }

    public CmdLogView beginPos(long beginPos) {
        add(new KeyValueParameter("begin_pos", beginPos + ""));
        return this;
    }

    public CmdLogView instance(boolean useInstance) {
        add(new KeyValueParameter("instance", QueryUtils.toInt(useInstance)));
        return this;
    }

    public CmdLogView lines(int lines) {
        add(new KeyValueParameter("lines", lines));
        return this;
    }

    public CmdLogView reverse(boolean isReverse) {
        add(new KeyValueParameter("reverse", QueryUtils.toInt(isReverse)));
        return this;
    }

}
