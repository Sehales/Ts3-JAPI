package net.sehales.streamlimiter;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.concurrent.TimeUnit;

public class ThrottledOutputStream extends BufferedOutputStream {

    // public static void main(String[] args) throws Exception {
    // File file = new File("D:/Calculator.zip");
    // InputStream inputStream = new URL("http://res.sehales.net/upload/test.zip").openConnection().getInputStream();
    //
    // ThrottledOutputStream throttledOutputStream = new ThrottledOutputStream(new FileOutputStream(file));
    // throttledOutputStream.setVerbose(true);
    //
    // throttledOutputStream.setMaxMegaBytesPerSecond(10);
    //
    // long time = -System.currentTimeMillis();
    //
    // byte[] buffer = new byte[16384];
    //
    // for (int bytesRead = inputStream.read(buffer); bytesRead >= 0; bytesRead = inputStream.read(buffer)) {
    // throttledOutputStream.write(buffer, 0, bytesRead);
    // }
    // throttledOutputStream.close();
    // inputStream.close();
    // time += System.currentTimeMillis();
    //
    // System.out.println((time / 1000.0) + " s");
    // // System.out.println(((file.length() / 1024) / (time / 1000)) + " kb / s");
    // }

    private int     maxKiloBytesPerSecond;
    private long    maxBytesPerMilliSecond;
    private long    startTimeMillis = -1;
    private long    overallBytesWritten;

    private boolean verbose;

    public ThrottledOutputStream(OutputStream out) {
        super(out);
    }

    public int getMaxKiloBytesPerSecond() {
        return maxKiloBytesPerSecond;
    }

    public boolean isVerbose() {
        return verbose;
    }

    public void setMaxKiloBytesPerSecond(int maxKiloBytesPerSecond) {
        this.maxKiloBytesPerSecond = maxKiloBytesPerSecond;
        maxBytesPerMilliSecond = (maxKiloBytesPerSecond * 1024) / 1000;
    }

    public void setMaxMegaBytesPerSecond(int maxMegaBytesPerSecond) {
        maxMegaBytesPerSecond *= 1024;
        maxKiloBytesPerSecond = maxMegaBytesPerSecond;
        maxBytesPerMilliSecond = (maxKiloBytesPerSecond * 1024) / 1000;
    }

    public void setVerbose(boolean verbose) {
        this.verbose = verbose;
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        super.write(b, off, len);
        overallBytesWritten += len - off;
        if (startTimeMillis == -1) {
            startTimeMillis = System.currentTimeMillis();
        } else {
            long deltaTimeMillis = System.currentTimeMillis() - startTimeMillis;
            long expectedBytesWritten = deltaTimeMillis
                            * maxBytesPerMilliSecond;

            if (verbose) {
                System.out.printf("dt: %s, eobw: %s, obw: %s\n",
                                deltaTimeMillis, expectedBytesWritten,
                                overallBytesWritten);
            }

            if (expectedBytesWritten < overallBytesWritten) {
                long deltaBytesWritten = overallBytesWritten
                                - expectedBytesWritten;
                long timeToSleepInMilliSeconds = deltaBytesWritten
                                / maxBytesPerMilliSecond;
                if (timeToSleepInMilliSeconds > 0) {
                    if (verbose) {
                        System.out.println("Sleep: " + timeToSleepInMilliSeconds);
                    }
                    try {
                        TimeUnit.MILLISECONDS.sleep(timeToSleepInMilliSeconds);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
