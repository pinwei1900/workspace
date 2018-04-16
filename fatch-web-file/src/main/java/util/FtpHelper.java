package util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.SocketException;
import java.net.URL;
import org.apache.commons.net.ftp.FTPClient;

/**
 * This program demonstrates how to download a file from FTP server using FTP URL.
 *
 * @author haosonglin
 */
public class FtpHelper {

    private static final int BUFFER_SIZE = 4096;
    private static final String PATH_Prefix = "E:/Download/";

    private final String host;
    private FTPClient client;

    public FtpHelper(String host) {
        this.host = host;
    }

    public boolean download(String ftpUrl) throws IOException {

        if (client == null) {
            synchronized (client) {
                if (client == null) {
                    client = new FTPClient();
                }
            }
        }

        URL l = null;
        FileOutputStream outputStream = null;
        try {
            l = new URL(ftpUrl);
            client.connect(l.getHost());
            client.enterLocalPassiveMode();
            client.login("anonymous", "");

            outputStream = new FileOutputStream(getSavePath(ftpUrl));
        } catch (Exception e) {
            return false;
        }

        boolean isSucc =  client.retrieveFile(l.getFile(), outputStream);
        outputStream.close();
        return isSucc;
    }

    public void close() throws IOException {
        client.disconnect();
    }

    public String getPathSuffix(String ftpUrl) {
        return ftpUrl.substring(ftpUrl.lastIndexOf("/") + 1);
    }

    public String getSavePath(String ftpUrl) {
        return PATH_Prefix + getPathSuffix(ftpUrl);
    }
}