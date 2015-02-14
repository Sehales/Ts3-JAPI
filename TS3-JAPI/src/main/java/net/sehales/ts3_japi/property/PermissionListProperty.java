package net.sehales.ts3_japi.property;

import net.sehales.ts3_japi.command.CmdPermissionList;

/**
 * used by {@link CmdPermissionList}
 * 
 * @author Sehales
 *
 */
public enum PermissionListProperty {
    PERMID,
    PERMNAME,
    PERMDESC;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
