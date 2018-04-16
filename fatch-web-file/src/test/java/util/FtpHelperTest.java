package util;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import org.apache.commons.net.ftp.FTPClient;
import org.junit.After;
import org.junit.Test;

public class FtpHelperTest {

    private FtpHelper ftpHelper = new FtpHelper();
    private String url = "ftp://ftp.ncbi.nlm.nih.gov/genomes/all/GCF/000/010/525/GCF_000010525.1_ASM1052v1/GCF_000010525.1_ASM1052v1_genomic.fna.gz";

    @Test
    public void getPathSuffix() throws Exception {

        URL l = new URL(url);
        System.out.println(l.toString());
        System.out.println(l.getFile());
        System.out.println(l.getHost());
        System.out.println(l.getPath());
        System.out.println(l.getQuery());
        System.out.println(l.getAuthority());









//        assertEquals("B",ftpHelper.getPathSuffix("C:/A/B"));
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void download() throws Exception {
        ftpHelper.download(url);
    }

    @Test
    public void download2() throws IOException {

        URL l = new URL(url);
        FTPClient client = new FTPClient();
        try {
            client.connect(l.getHost());
            client.enterLocalPassiveMode();
            client.login("anonymous", "");
        } catch (IOException e) {
            e.printStackTrace();
        }

        FileOutputStream outputStream = new FileOutputStream(ftpHelper.getSavePath(url));
        boolean isSucc = client.retrieveFile(l.getFile(), outputStream);
        outputStream.close();
        client.disconnect();
    }
}