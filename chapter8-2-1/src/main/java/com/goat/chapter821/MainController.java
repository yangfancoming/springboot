package com.goat.chapter821;


import com.goat.chapter821.config.FtpConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class MainController {

//    @Autowired
//    private FTPService ftpService;

    private static Logger log = LoggerFactory.getLogger(MainController.class);

    @Autowired
    FtpConfig ftpConfig;
    // http://localhost:8821/upload
    @GetMapping("/upload")
    public void uploadExample(){


    }


}
