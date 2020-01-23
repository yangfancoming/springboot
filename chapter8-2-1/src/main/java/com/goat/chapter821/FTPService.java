package com.goat.chapter821;


import java.io.File;

/**
 * Created by Yoandy Pérez Villazón on 13/09/17.
 */
public interface FTPService {
     void connectToFTP(String host, String user, String pass) ;
     void uploadFileToFTP(File file, String ftpHostDir, String serverFilename) ;
     void downloadFileFromFTP(String ftpRelativePath, String copytoPath) ;
     void disconnectFTP() ;

}
