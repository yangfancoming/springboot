package com.goat.controller;

import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * @Description:  单个文件上传
 * @author: Goat
 * @Date:   2018/12/18
*/
@RestController
public class SingleUploadController {

    /**
     * 上传文件方法
     * @param file 前台上传的文件对象
     *  测试地址：  http://localhost:8261/upload
     */
    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public @ResponseBody String upload(MultipartFile file) {
        try {
            String uploadDir = getClass().getResource("/").getPath();// 获取项目真实路径
            //如果目录不存在，自动创建文件夹
            File dir = new File(uploadDir);
            if(!dir.exists()){
                dir.mkdir();
            }
            String suffix = file.getOriginalFilename();  //文件名
            //上传文件名
            File serverFile = new File(uploadDir + suffix);//服务器端保存的文件对象
            file.transferTo(serverFile);//将上传的文件写入到服务器指定路径下
        }catch (Exception e) {
            e.printStackTrace();
            return "上传失败";
        }
        return "上传成功";
    }


//    http://localhost:8261/read
    @RequestMapping(value = "/read",method = RequestMethod.GET)
    public void read(HttpServletRequest request) throws FileNotFoundException {
//        File file = ResourceUtils.getFile("classpath:cer.cer");
        File file = ResourceUtils.getFile("/cer.cer");
        System.out.println(file);

    }
}
