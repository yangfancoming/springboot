package com.goat.controller;

import com.goat.service.ImageUploadService;
import com.goat.service.ImgWatermarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * Created by 64274 on 2019/3/6.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/3/6---16:06
 */

@RestController
public class FileUploadController {

    @Autowired
    private ImageUploadService imageUploadService;

    @Autowired
    private ImgWatermarkService watermarkService;

    /**
     {
     "imageUrl": "static/images//123.png",
     "logoImageUrl": "static/images//watermark_123.png"
     }
     */
    @RequestMapping(value = "/watermarktest", method = RequestMethod.POST)
    public String watermarkTest( @RequestParam("file") MultipartFile image ) {
        String uploadPath = "static/imgs/";  // 服务器上上传文件的相对路径
        String physicalUploadPath = getClass().getClassLoader().getResource(uploadPath).getPath();  // 服务器上上传文件的物理路径
        String imageURL = imageUploadService.uploadImage( image, uploadPath, physicalUploadPath ); // 上传文件操作
        File imageFile = new File(physicalUploadPath + image.getOriginalFilename() );
        String watermarkAddImageURL = watermarkService.watermarkAdd(imageFile, image.getOriginalFilename(), uploadPath, physicalUploadPath);// 给上传的图片添加水印
        return  imageURL + "-----------" + watermarkAddImageURL;
    }
}

