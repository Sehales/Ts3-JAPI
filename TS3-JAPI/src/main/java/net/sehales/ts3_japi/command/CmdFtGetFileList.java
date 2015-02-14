package net.sehales.ts3_japi.command;

import java.util.List;

import net.sehales.ts3_japi.command.parameter.KeyValueParameter;
import net.sehales.ts3_japi.property.FileProperty;
import net.sehales.ts3_japi.wrapper.MapWrapper;

public class CmdFtGetFileList extends ArrayResponseCommand {

    public CmdFtGetFileList(int channelId, String channelPassword, String filePath) {
        super("ftgetfilelist");
        add(new KeyValueParameter("cid", channelId));
        add(new KeyValueParameter("cpw", channelPassword));
        add(new KeyValueParameter("name", filePath));
    }

    /**
     * @return the {@link MapWrapper} objects contain entries with the keys specified by {@link FileProperty}
     */
    @Override
    public List<MapWrapper> getResponseWrapper() {
        return response.getWrapperList();
    }

}
