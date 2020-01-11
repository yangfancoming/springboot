package com.goat.chapter821;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;


@RestController
public class MainController {

    @Autowired
    private FTPService ftpService;

    @GetMapping("/upload")
    public void uploadExample(){
        ftpService.connectToFTP("192.168.211.128","minioadmin","minioadmin");

        ftpService.uploadFileToFTP(new File("/home/yoandypv/img.png"),"uploads/","foto.png");
        ftpService.downloadFileFromFTP("uploads/foto.png","/home/kaka.png");

    }


}
