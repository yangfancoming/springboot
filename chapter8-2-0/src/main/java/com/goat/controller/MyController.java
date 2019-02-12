package com.goat.controller;


import com.goat.fastdfs.FastDFSClientWrapper;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;

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
    @RequestMapping(value = "/upload")
    public String upload(MultipartFile file, HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 省略业务逻辑代码。。。
        String imgUrl = dfsClient.uploadFile(file);
        System.out.println(imgUrl);
        return imgUrl; // http://192.168.235.207/group1/M00/00/00/wKjrz1xBjWGAezm-AAAAZeAEstw525.txt
    }

    // 上传图片  http://localhost:8820/delete?fileUrl=group1/M00/00/00/wKjrz1xiNyeAChhWAADSADZFffY398.png
    @RequestMapping(value = "/delete")
    public void deleteFile(String fileUrl) {
        dfsClient.deleteFile(fileUrl);
    }

    /**
     * 文件下载
     * @param fileUrl  url 开头从组名开始  http://localhost:8820/download?fileUrl=group1/M00/00/00/wKjrz1xiPgKAEWvuAAAYIMYNlFA91.xlsx
     * @param response
     * @param fileName  文件下载后的 名称需带扩展名  eg： "test.xlsx"
     * @throws Exception
     */
    @RequestMapping("/download")
    public void  download(HttpServletResponse response,String fileUrl,String fileName) throws Exception{
        byte[] data = dfsClient.download(fileUrl);
        response.setCharacterEncoding("UTF-8");
        response.setContentType(MediaType.TEXT_HTML_VALUE);
        response.setHeader("Content-disposition", "attachment;filename=" + URLEncoder.encode(fileName,"UTF-8"));
        ServletOutputStream outputStream = response.getOutputStream();// 写出
        IOUtils.write(data, outputStream);
    }


}
