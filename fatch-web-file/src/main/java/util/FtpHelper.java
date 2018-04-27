package util;

import bean.DownFile;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.commons.compress.compressors.gzip.GzipCompressorInputStream;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.pool.impl.SoftReferenceObjectPool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This program demonstrates how to download a file from FTP server using FTP URL.
 *
 * @author haosonglin
 */
public class FtpHelper {

    private static final Logger logger = LoggerFactory.getLogger(FtpHelper.class);

    private static String PATH_Prefix;

    private final SoftReferenceObjectPool poll;

    public FtpHelper(String path) {
        this.PATH_Prefix = path;
        this.poll = new SoftReferenceObjectPool(new FtpConnFactory());
    }


    //用来解压文件的方法，如果这个方法失败了，那么如果outfile还存在的话，需要删除这个文件，temfile无论成功与否都需要被删除，因为此文件解压失败，说明文件有问题
    private static void unCompressArchiveGz(File temfile, String  outPath) throws IOException {
        File outfile = new File(outPath);
        //防止程序在被中断时没有即使删除文件
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(temfile));
                BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(outfile));
                GzipCompressorInputStream gcis = new GzipCompressorInputStream(bis)) {
            byte[] buffer = new byte[1024];
            int read;
            while ((read = gcis.read(buffer)) != -1) {
                bos.write(buffer, 0, read);
            }
            bos.flush();
        } catch (Exception e) {
            delete(outfile);
            throw e;
        }
    }

    public boolean download(DownFile downFile) {
        boolean isSucc;

        File temfile = new File(PATH_Prefix + downFile.getName() + "_tmp");
        delete(temfile);

        try (FileOutputStream outputStream = new FileOutputStream(temfile)) {
            FTPClient client = (FTPClient) poll.borrowObject();
            isSucc = client.retrieveFile(downFile.getPath(), outputStream);
            if (isSucc) {
                outputStream.close();
                unCompressArchiveGz(temfile, temfile.getParent() + File.separator + downFile.getName());
            }
            poll.returnObject(client);
            return isSucc;
        } catch (Exception e) {
            logger.error("download error :" + downFile.getName(), e);
            return false;
        } finally {
            delete(temfile);
        }
    }

    private static void delete(File file) {
        if (file.exists()) {
            file.delete();
        }
    }

    public static String getPathSuffix(String ftpUrl) {
        return ftpUrl.substring(ftpUrl.lastIndexOf("/") + 1, ftpUrl.lastIndexOf("."));
    }
}