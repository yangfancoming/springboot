package com.goat.controller;

//import com.github.tobato.fastdfs.domain.StorePath;
//import com.github.tobato.fastdfs.domain.ThumbImageConfig;
import com.github.tobato.fastdfs.domain.fdfs.StorePath;
import com.github.tobato.fastdfs.domain.fdfs.ThumbImageConfig;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created by 64274 on 2019/1/17.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/1/17---12:02
 */
@Controller
public class UpLoadFileController {

    @Autowired
    private FastFileStorageClient storageClient;

    @Autowired
    private ThumbImageConfig thumbImageConfig;

    @GetMapping("/")
    public String index() {
        return "upload";
    }

    File file = new File("E:\\FFOutput\\baby.png");

    @PostMapping("/testUpload1")
    @ResponseBody
    public void testUpload1() throws FileNotFoundException {
        // 上传并且生成缩略图
        StorePath storePath = this.storageClient.uploadFile(new FileInputStream(file), file.length(), "png", null);
        System.out.println(storePath.getFullPath()); // 带分组的路径
        System.out.println(storePath.getPath()); // 不带分组的路径
    }

    @PostMapping("/testUpload2")
    @ResponseBody
    public void testUpload2() throws FileNotFoundException {
        // 上传并且生成缩略图
        StorePath storePath = this.storageClient.uploadImageAndCrtThumbImage(new FileInputStream(file), file.length(), "png", null);
        System.out.println(storePath.getFullPath());// 带分组的路径
        System.out.println(storePath.getPath());  // 不带分组的路径
        String path = thumbImageConfig.getThumbImagePath(storePath.getPath());// 获取缩略图路径
        System.out.println(path);
    }
}
