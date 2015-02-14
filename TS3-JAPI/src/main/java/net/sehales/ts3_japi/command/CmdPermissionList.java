package net.sehales.ts3_japi.command;

import java.util.List;

import net.sehales.ts3_japi.command.parameter.OptionParameter;
import net.sehales.ts3_japi.property.PermissionListProperty;
import net.sehales.ts3_japi.wrapper.MapWrapper;

public class CmdPermissionList extends ArrayResponseCommand {

    public CmdPermissionList() {
        super("permissionlist");
    }

    /**
     * Take a look at {@link PermissionListProperty} for possible keys for obtaining values from this <code>List<{@link MapWrapper}></code>
     */
    @Override
    public List<MapWrapper> getResponseWrapper() {
        return response.getWrapperList();
    }

    /**
     * this actually add the option "-new" to the command, but due to "new" is a reserved word the method is named "listNew" instead of just "new"
     */
    public CmdPermissionList listNew() {
        add(new OptionParameter("new"));
        return this;
    }
}
