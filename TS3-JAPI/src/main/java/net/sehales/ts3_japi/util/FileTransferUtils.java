package net.sehales.ts3_japi.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.zip.CRC32;

import net.sehales.streamlimiter.ThrottledOutputStream;
import net.sehales.ts3_japi.command.CmdFtInitUpload;
import net.sehales.ts3_japi.property.FileTransferInitProperty;
import net.sehales.ts3_japi.wrapper.MapWrapper;

public class FileTransferUtils {

    /**
     * used to create a CRC32 checksum which is needed as value for setting icons
     * 
     * @param file
     *            the {@link File} to read from
     * @return CRC32 checksum casted to an {@link Integer}
     * @throws IOException
     */
    public static int checksum(File file) throws IOException {
        try (InputStream inputStream = new BufferedInputStream(new FileInputStream(file))) {
            return checksum(inputStream);
        }
    }

    /**
     * used to create a CRC32 checksum which is needed as value for setting icons
     * 
     * @param in
     *            the {@link InputStream} to read from
     * @return CRC32 checksum casted to an {@link Integer}
     * @throws IOException
     */
    public static int checksum(InputStream in) throws IOException {
        CRC32 crc = new CRC32();
        int n;
        while ((n = in.read()) != -1) {
            crc.update(n);
        }
        return (int) crc.getValue();
    }

    public static void upload(File file, CmdFtInitUpload cmd) throws IOException {
        upload(new BufferedInputStream(new FileInputStream(file)), cmd);
    }

    // TODO
    public static void upload(InputStream in, CmdFtInitUpload cmd) throws IOException {
        MapWrapper wrapper = cmd.getResponse().getWrapper();
        int port = wrapper.getInt(FileTransferInitProperty.PORT);
        String host = wrapper.getString(FileTransferInitProperty.IP);
        String ftkey = wrapper.getString(FileTransferInitProperty.FTKEY);
        Socket sock = new Socket(host, port);
        OutputStream out = sock.getOutputStream();
        out.write(ftkey.getBytes());

        byte[] b = new byte[1024];
        while (in.read(b) != -1) {
            out.write(b);
        }
        sock.close();
    }

    // TODO
    public static void upload(InputStream in, CmdFtInitUpload cmd, int kiloBytesPerSecond) throws IOException {
        MapWrapper wrapper = cmd.getResponse().getWrapper();
        int port = wrapper.getInt(FileTransferInitProperty.PORT);
        String host = wrapper.getString(FileTransferInitProperty.IP);
        String ftkey = wrapper.getString(FileTransferInitProperty.FTKEY);
        Socket sock = new Socket(host, port);
        ThrottledOutputStream out = new ThrottledOutputStream(sock.getOutputStream());
        out.setMaxKiloBytesPerSecond(kiloBytesPerSecond);
        out.setVerbose(true);
        out.write(ftkey.getBytes());

        byte[] b = new byte[1024];
        while (in.read(b) != -1) {
            out.write(b);
        }
        out.close();
        sock.close();
    }
}
