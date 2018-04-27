/*
 * Copyright (c) 2018年04月27日 by XuanWu Wireless Technology Co.Ltd. 
 *             All rights reserved                         
 */
package util;


import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.pool.BasePoolableObjectFactory;

/**
 * @Description
 * @Author <a href="mailto:haosonglin@wxchina.com">songlin.Hao</a>
 * @Date 2018/4/27
 * @Version 1.0.0
 */
public class FtpConnFactory extends BasePoolableObjectFactory<FTPClient> {

    @Override
    public FTPClient makeObject() throws Exception {
        FTPClient client = new FTPClient();
        client.connect("ftp.ncbi.nlm.nih.gov");
        client.enterLocalPassiveMode();
        client.login("anonymous", "");
        client.setFileType(FTP.BINARY_FILE_TYPE);
        return client;
    }

    @Override
    public void destroyObject(FTPClient obj) throws Exception {
        super.destroyObject(obj);
    }

    @Override
    public boolean validateObject(FTPClient obj) {
        return super.validateObject(obj);
    }

    @Override
    public void activateObject(FTPClient obj) throws Exception {
        super.activateObject(obj);
    }

    @Override
    public void passivateObject(FTPClient obj) throws Exception {
        super.passivateObject(obj);
    }
}
