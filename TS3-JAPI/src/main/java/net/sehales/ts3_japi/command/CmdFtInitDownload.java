package net.sehales.ts3_japi.command;

import net.sehales.ts3_japi.command.parameter.KeyValueParameter;
import net.sehales.ts3_japi.property.FileTransferInitProperty;
import net.sehales.ts3_japi.wrapper.MapWrapper;

public class CmdFtInitDownload extends ArrayResponseCommand {

    public CmdFtInitDownload(int clientFileTransferId, String filePath, int channelId, String channelPassword, long seekPos) {
        super("ftinitdownload");
        add(new KeyValueParameter("clientftfid", clientFileTransferId));
        add(new KeyValueParameter("name", filePath));
        add(new KeyValueParameter("cid", channelId));
        add(new KeyValueParameter("cpw", channelPassword));
        add(new KeyValueParameter("seekpos", seekPos));
    }

    /**
     * @return A {@link MapWrapper} which contains entries with the keys defined in {@link FileTransferInitProperty} except
     *         {@link FileTransferInitProperty#SEEKPOS}
     */
    @Override
    public MapWrapper getResponseWrapper() {
        return response.getWrapper();
    }

}
