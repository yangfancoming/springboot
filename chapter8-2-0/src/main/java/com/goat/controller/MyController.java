package com.goat.controller;

import com.goat.fastdfs.FastDFSClientWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by 64274 on 2019/1/17.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/1/17---12:15
 */
@RestController
public class MyController {

    @Autowired
    private FastDFSClientWrapper dfsClient;

    // 上传图片  http://localhost:8820/upload
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String upload(MultipartFile file, HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 省略业务逻辑代码。。。
        String imgUrl = dfsClient.uploadFile(file);
        System.out.println(imgUrl);
        return imgUrl; // http://192.168.235.207/group1/M00/00/00/wKjrz1xBjWGAezm-AAAAZeAEstw525.txt
    }
}
