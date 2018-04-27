/*
 * Copyright (c) 2018年04月27日 by XuanWu Wireless Technology Co.Ltd. 
 *             All rights reserved                         
 */
package util;


import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.pool.BasePoolableObjectFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description
 * @Author <a href="mailto:haosonglin@wxchina.com">songlin.Hao</a>
 * @Date 2018/4/27
 * @Version 1.0.0
 */
public class FtpConnFactory extends BasePoolableObjectFactory<FTPClient> {

    private static final Logger logger = LoggerFactory.getLogger(FtpHelper.class);

    @Override
    public FTPClient makeObject() throws Exception {
        FTPClient client = new FTPClient();
        client.connect("ftp.ncbi.nlm.nih.gov");
        client.enterLocalPassiveMode();
        client.login("anonymous", "");
        client.setFileType(FTP.BINARY_FILE_TYPE);

        logger.info("创建一个连接" + client);
        return client;
    }

    @Override
    public void destroyObject(FTPClient obj) throws Exception {
        obj.disconnect();
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
