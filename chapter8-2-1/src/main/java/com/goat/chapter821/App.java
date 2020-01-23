package com.goat.chapter821;

import org.apache.commons.net.ftp.FTPClient;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static com.goat.chapter821.MyFtpOperUtils.*;
import static com.goat.chapter821.MyFtpUtils.closeFTPConnect;

/**
 * Created by Administrator on 2020/1/10.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2020/1/10---17:33
 */
public class App {

    FTPClient ftpClient = MyFtpUtils.connectFtpServer("192.168.211.128", 21, "test", "test", "UTF-8");

    @Test
    public void connectFtpServer(){
        System.out.println("-----------------------应用启动------------------------");
        System.out.println("FTP 连接是否成功：" + ftpClient.isConnected());
        System.out.println("FTP 连接是否有效：" + ftpClient.isAvailable());
        closeFTPConnect(ftpClient);
        System.out.println("-----------------------应用关闭------------------------");
    }

    @Test
    public void down(){
        System.out.println("-----------------------应用启动------------------------");
        downloadSingleFile(ftpClient, "D:\\123\\ftpDownload", "\\home\\vsftpd\\test\\");
        closeFTPConnect(ftpClient);
        System.out.println("-----------------------应用关闭------------------------");
    }
    @Test
    public void down2(){
        System.out.println("-----------------------应用启动------------------------");
        List<String> relativePathList = new ArrayList<>();
        relativePathList = loopServerPath(ftpClient, "\\home\\vsftpd\\test\\123\\log\\", relativePathList);
        for (String relativePath : relativePathList) {
            System.out.println("准备下载的服务器文件：" + relativePath);
            downloadSingleFile(ftpClient, "E:\\123\\4444", relativePath);
        }

        closeFTPConnect(ftpClient);
        System.out.println("-----------------------应用关闭------------------------");
    }

    @Test
    public void upload(){
        System.out.println("-----------------------应用启动------------------------");
        uploadFiles(ftpClient, new File("D:\\123\\12.txt"));
        closeFTPConnect(ftpClient);
        System.out.println("-----------------------应用关闭------------------------");
    }

    @Test
    public void upload2(){
        System.out.println("-----------------------应用启动------------------------");
        uploadFiles(ftpClient, new File("D:\\123\\"));
        closeFTPConnect(ftpClient);
        System.out.println("-----------------------应用关闭------------------------");
    }

    @Test
    public void delete(){
        System.out.println("-----------------------应用启动------------------------");
        deleteServerFiles(ftpClient,"/");
        closeFTPConnect(ftpClient);
        System.out.println("-----------------------应用关闭------------------------");
    }

}
