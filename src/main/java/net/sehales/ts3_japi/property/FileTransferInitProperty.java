package net.sehales.ts3_japi.property;

import net.sehales.ts3_japi.command.CmdFtInitDownload;
import net.sehales.ts3_japi.command.CmdFtInitUpload;

/**
 * used for return values of {@link CmdFtInitUpload} and {@link CmdFtInitDownload}
 * 
 * @author Sehales
 *
 */
public enum FileTransferInitProperty implements Property {
    PORT,
    SERVERFTFID,
    CLIENTFTFID,
    FTKEY,
    IP,
    /**
     * only returned by {@link CmdFtInitUpload}
     */
    SEEKPOS,
    /**
     * only returned by {@link CmdFtInitDownload}
     */
    SIZE;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
