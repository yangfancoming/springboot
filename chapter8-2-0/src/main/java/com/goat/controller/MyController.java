package com.goat.controller;


import com.goat.fastdfs.FastDFSClientWrapper;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
/**

     group1/M00/00/00/wKjrz1xhRB6AGrcSAADSADZFffY772.png

 	组名：(group1) 文件上传后所在的storage组名称，在文件上传成功后有storage服务器返回，需要客户端自行保存。
 	虚拟磁盘路径(M00)：storage配置的虚拟路径，与磁盘选项store_path*对应。如果配置了store_path0则是M00，如果配置了store_path1则是M01，以此类推。
 	数据两级目录(/00/00/)：storage服务器在每个虚拟磁盘路径下创建的两级目录，用于存储数据文件。
 	文件名(wKjrz1xhRB6AGrcSAADSADZFffY772)：与文件上传时不同。是由存储服务器根据特定信息生成，
                文件名包含：源存储服务器IP地址、文件创建时间戳、文件大小、随机数和文件拓展名等信息。

 */
//
//    M00/00/00/wKjrz1xhRB6AGrcSAADSADZFffY772.png
    // 上传图片  http://localhost:8820/delete?fileUrl=M00/00/00/wKjrz1xhPr-Aa9FsAADSADZFffY361.png
    @RequestMapping(value = "/delete")
    public void deleteFile(String fileUrl) {
        dfsClient.deleteFile(fileUrl);
    }

    /**
     * 文件下载
     * @param fileUrl  url 开头从组名开始  http://localhost:8820/download?fileUrl=group1/M00/00/00/wKjrz1xhRB6AGrcSAADSADZFffY772.png
     * @param response
     * @throws Exception
     */
    @RequestMapping("/download")
    public void  download(String fileUrl, HttpServletResponse response) throws Exception{
        byte[] data = dfsClient.download(fileUrl);
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-disposition", "attachment;filename=" + URLEncoder.encode("test.jpg", "UTF-8"));
        // 写出
        ServletOutputStream outputStream = response.getOutputStream();
        IOUtils.write(data, outputStream);
    }


}
