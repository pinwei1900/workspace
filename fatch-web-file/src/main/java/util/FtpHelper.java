package util;

import bean.DownFile;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.apache.commons.net.ftp.FTPClient;

/**
 * This program demonstrates how to download a file from FTP server using FTP URL.
 *
 * @author haosonglin
 */
public class FtpHelper {

    private static String PATH_Prefix;

    public FtpHelper(String path) {
        this.PATH_Prefix = path;
    }

    public boolean download(DownFile downFile) {
        boolean isSucc;
        FileOutputStream outputStream = null;
        FTPClient client = new FTPClient();
        String savepath = PATH_Prefix + downFile.getName();
        String temppath = PATH_Prefix + downFile.getName() + "_tmp";
        File temfile = new File(temppath);

        try {
            if (temfile.exists()) {
                temfile.delete();
            }

            client.connect(downFile.getHost());
            client.enterLocalPassiveMode();
            client.login("anonymous", "");
            outputStream = new FileOutputStream(temppath);
            isSucc = client.retrieveFile(downFile.getPath(), outputStream);

            outputStream.close();
            outputStream = null;
            client.disconnect();
            client = null;

            if (isSucc) {
                Path source = Paths.get(temppath);
                Files.move(source, source.resolveSibling(savepath));
            }

            return isSucc;
        } catch (Exception e) {
            return false;
        } finally {
            if (client != null) {
                try {
                    client.disconnect();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (temfile.exists()) {
                temfile.delete();
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static String getSavePath(String ftpUrl) {
        return PATH_Prefix + getPathSuffix(ftpUrl);
    }

    public static String getPathSuffix(String ftpUrl) {
        return ftpUrl.substring(ftpUrl.lastIndexOf("/") + 1);
    }

    public void close() throws IOException {

    }
}