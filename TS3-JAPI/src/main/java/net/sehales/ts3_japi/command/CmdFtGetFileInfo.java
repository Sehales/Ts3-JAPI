package net.sehales.ts3_japi.command;

import java.util.List;

import net.sehales.ts3_japi.command.parameter.ArrayParameter;
import net.sehales.ts3_japi.command.parameter.KeyValueParameter;
import net.sehales.ts3_japi.property.ChannelProperty;
import net.sehales.ts3_japi.property.FileProperty;
import net.sehales.ts3_japi.wrapper.MapWrapper;

public class CmdFtGetFileInfo extends ArrayResponseCommand {
    private ArrayParameter array = new ArrayParameter();

    public CmdFtGetFileInfo() {
        super("ftgetfileinfo");
    }

    public CmdFtGetFileInfo(int channelId, String channelPassword, String filePath) {
        this();
        add(channelId, channelPassword, filePath);
    }

    public CmdFtGetFileInfo add(int channelId, String channelPassword, String filePath) {
        add(new KeyValueParameter("cid", channelId));
        add(new KeyValueParameter("cpw", channelPassword));
        add(new KeyValueParameter("name", filePath));
        return this;
    }

    @Override
    public String buildString() {
        add(array);
        return super.buildString();
    }

    /**
     * @return A <code>List<{@link MapWrapper}></code> with each having three entries available over the following keys: {@link ChannelProperty#CID},
     *         {@link FileProperty#SIZE} and {@link FileProperty#DATETIME}
     */
    @Override
    public List<MapWrapper> getResponseWrapper() {
        return response.getWrapperList();
    }

}
