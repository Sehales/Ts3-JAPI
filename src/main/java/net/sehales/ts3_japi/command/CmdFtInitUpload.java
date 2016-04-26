package net.sehales.ts3_japi.command;

import net.sehales.ts3_japi.command.parameter.KeyValueParameter;
import net.sehales.ts3_japi.property.FileTransferInitProperty;
import net.sehales.ts3_japi.util.QueryUtils;
import net.sehales.ts3_japi.wrapper.MapWrapper;

public class CmdFtInitUpload extends ArrayResponseCommand {

    public CmdFtInitUpload(int clientFileTransferId, String fileName, int channelId, String channelPassword, long size, boolean overwrite, boolean resume) {
        super("ftinitupload");
        add(new KeyValueParameter("clientftfid", clientFileTransferId));
        add(new KeyValueParameter("name", fileName));
        add(new KeyValueParameter("cid", channelId));
        add(new KeyValueParameter("cpw", channelPassword));
        add(new KeyValueParameter("size", size));
        add(new KeyValueParameter("overwrite", QueryUtils.toInt(overwrite)));
        add(new KeyValueParameter("resume", QueryUtils.toInt(resume)));
    }

    /**
     * @return A {@link MapWrapper} which contains entries with the keys defined in {@link FileTransferInitProperty} except
     *         {@link FileTransferInitProperty#SIZE}
     */
    @Override
    public MapWrapper getResponseWrapper() {
        return response.getWrapper();
    }
}
