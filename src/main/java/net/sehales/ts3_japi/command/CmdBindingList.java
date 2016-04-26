package net.sehales.ts3_japi.command;

import java.util.ArrayList;
import java.util.List;

import net.sehales.ts3_japi.property.BindingListProperty;

public class CmdBindingList extends ArrayResponseCommand {

    public CmdBindingList() {
        super("bindinglist");
    }

    private List<String> getIPList() {
        List<String> ips = new ArrayList<>();
        response.getWrapperList().forEach(w -> ips.add(w.getString(BindingListProperty.IP)));
        return ips;
    }

    /**
     * Due to the circumstance that this command has only one key value pair in it's response it directly returns a list of those values
     * 
     * @return a list of strings returned by {@link BindingListProperty#IP}
     */
    @Override
    public List<String> getResponseWrapper() {
        return getIPList();
    }

}
