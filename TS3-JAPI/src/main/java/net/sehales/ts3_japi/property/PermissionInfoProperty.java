package net.sehales.ts3_japi.property;

import net.sehales.ts3_japi.command.CmdPermFind;
import net.sehales.ts3_japi.command.CmdPermOverview;

/**
 * Used by {@link CmdPermFind} and {@link CmdPermOverview}.
 * 
 * </p>for {@link CmdPermOverview} the following table shows how it is used:
 * <table cellpadding=5>
 * <thead>
 * <tr>
 * <th>{@link #T} (Type)</th>
 * <th>Meaning</th>
 * <th>{@link #ID1}</th>
 * <th>{@link #ID2}</th>
 * </tr>
 * 
 * <tr>
 * <td>0</td>
 * <td>Server group</td>
 * <td>Server group id</td>
 * <td>0</td>
 * </tr>
 * 
 * <tr>
 * <td>1</td>
 * <td>Client (Server layer)</td>
 * <td>Client database id</td>
 * <td>0</td>
 * </tr>
 *
 * <tr>
 * <td>2</td>
 * <td>Channel</td>
 * <td>Channel id</td>
 * <td>0</td>
 * </tr>
 *
 * <tr>
 * <td>3</td>
 * <td>Channel group</td>
 * <td>Channel id</td>
 * <td>Channel group id</td>
 * </tr>
 *
 * <tr>
 * <td>4</td>
 * <td>Client (Channel layer)</td>
 * <td>Channel id</td>
 * <td>Client database id</td>
 * </tr>
 *
 * </thead>
 * </table>
 * 
 * </p>for {@link CmdPermFind} the following table shows how it is used:
 * <table cellpadding=5>
 * <thead>
 * <tr>
 * <th>{@link #T} (Type)</th>
 * <th>Meaning</th>
 * <th>{@link #ID1}</th>
 * <th>{@link #ID2}</th>
 * </tr>
 * 
 * <tr>
 * <td>0</td>
 * <td>Server group</td>
 * <td>Server group id</td>
 * <td>0</td>
 * </tr>
 * 
 * <tr>
 * <td>1</td>
 * <td>Client (Server layer)</td>
 * <td>0</td>
 * <td>Client database id</td>
 * </tr>
 *
 * <tr>
 * <td>2</td>
 * <td>Channel</td>
 * <td>0</td>
 * <td>Channel id</td>
 * </tr>
 *
 * <tr>
 * <td>3</td>
 * <td>Channel group</td>
 * <td>Channel group id</td>
 * <td>0</td>
 * </tr>
 *
 * <tr>
 * <td>4</td>
 * <td>Client (Channel layer)</td>
 * <td>Client database id</td>
 * <td>Channel id</td>
 * </tr>
 *
 * </thead>
 * </table>
 * </p> {@link P} is always the permission id, a permsid isn't available
 * 
 * @author Sehales
 *
 */
public enum PermissionInfoProperty implements Property {

    T,
    ID1,
    ID2,
    P;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
// TODO
