//package com.goat.controller;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.multipart.MultipartFile;
//
//import javax.servlet.http.HttpServletRequest;
//import java.io.File;
//
///**
//     * @Description:  单个文件上传
//     * @author: 杨帆
//     * @Param:
//     * @Return:
//     * @Date:   2018/12/18
//*/
//@Controller
//public class MultipleUploadController {
//
//
//
//    /**
//     * 上传多个文件
//     * @param request 请求对象
//     * @param file 上传文件集合
//     * @return
//     */
//    @RequestMapping(value = "/uploads",method = RequestMethod.POST)
//    public @ResponseBody
//    String uploads(HttpServletRequest request, MultipartFile[] file)
//    {
//        try {
//            //上传目录地址
//            String uploadDir = request.getSession().getServletContext().getRealPath("/") +"upload/";
//            //如果目录不存在，自动创建文件夹
//            File dir = new File(uploadDir);
//            if(!dir.exists())
//            {
//                dir.mkdir();
//            }
//            //遍历文件数组执行上传
//            for (int i =0;i<file.length;i++) {
//                if(file[i] != null) {
//                    //调用上传方法
//                    FileUtils.executeUpload(uploadDir, file[i]);
//                }
//            }
//        }catch (Exception e)
//        {
//            //打印错误堆栈信息
//            e.printStackTrace();
//            return "上传失败";
//        }
//        return "上传成功";
//    }
//}
