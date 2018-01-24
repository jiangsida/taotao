package com.taotao.controller;

import org.apache.commons.net.ftp.FTPClient;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;


/**
 * @author jiang
 * @create 2017-12-19 10:51
 * @desc Ftp测试类
 **/
public class FtpJava {
    @Test
    public void TestFtp () {
        try {
            //1.常见ftp对象
            FTPClient ftpClient = new FTPClient ();
            //2 创建连接
            ftpClient.connect ("192.168.43.20", 22);

            //3、登录Ftp服务器使用账户密码
            ftpClient.login ("ftpuser", "123456");
             ftpClient.changeWorkingDirectory ("/home/ftpuser/www/images");
            FileInputStream inputStream=new FileInputStream (new File ("D:\\456-p01411.jpg"));
            //4、上传文件
            ftpClient.storeFile ("hello.jpg",inputStream);
             ftpClient.logout ();
        } catch (Exception e) {
            new RuntimeException ();
        }

    }

}
