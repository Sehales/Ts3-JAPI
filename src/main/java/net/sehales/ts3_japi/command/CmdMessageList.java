package net.sehales.ts3_japi.command;

import java.util.List;

import net.sehales.ts3_japi.property.MessageProperty;
import net.sehales.ts3_japi.wrapper.MapWrapper;

public class CmdMessageList extends ArrayResponseCommand {

    public CmdMessageList() {
        super("messagelist");
    }

    /**
     * The returned <code>List<{@link MapWrapper}></code> contains {@link MapWrapper} objects containing entries available via the keys specified in
     * {@link MessageProperty} except {@link MessageProperty#MESSAGE}
     */
    @Override
    public List<MapWrapper> getResponseWrapper() {
        return response.getWrapperList();
    }

}
