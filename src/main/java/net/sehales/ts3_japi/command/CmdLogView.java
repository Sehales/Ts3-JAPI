package net.sehales.ts3_japi.command;

import java.util.List;

import net.sehales.ts3_japi.command.parameter.KeyValueParameter;
import net.sehales.ts3_japi.property.LogProperty;
import net.sehales.ts3_japi.util.QueryUtils;
import net.sehales.ts3_japi.wrapper.MapWrapper;

public class CmdLogView extends ArrayResponseCommand {

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
        add(new KeyValueParameter("begin_pos", beginPos));
        return this;
    }

    /**
     * @returns a <code>List<{link MapWrapper}></code> with each {@link MapWrapper} containing one line available via the key {@link LogProperty#L}
     *          and entries with the other keys defined in {@link LogProperty}
     */
    @Override
    public List<MapWrapper> getResponseWrapper() {
        return response.getWrapperList();
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
