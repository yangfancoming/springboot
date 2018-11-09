package com.goat.utils;


import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.GetObjectRequest;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectResult;
import com.goat.config.AliyunOssConfig;

import java.io.File;

// sos ErrorCode: AccessDeniedErrorMessage: You have no right to access this object because of bucket acl
// 此问题 需要在阿里云后台  给对应用户进行响应授权后  即可解决

public class OssUtil {

    /**
         * @Description: 功能描述：上传文件到阿里云oss
         * @author: 杨帆
         * @Param:
         * @Return:
         * @Date:   2018/8/23
    */
    public static String uploadOss(AliyunOssConfig aliyunOssConfig) {
        OSSClient ossClient = new OSSClient(aliyunOssConfig.getEndPoint() , aliyunOssConfig.getAccessKey(), aliyunOssConfig.getSecretKey());
        ObjectMetadata meta = new ObjectMetadata(); // 创建上传Object的Metadata
        meta.setContentLength(4096); // 必须设置ContentLength
        meta.setHeader("Content-Disposition", "inline");
        PutObjectResult putObjectResult = ossClient.putObject(aliyunOssConfig.getBucket(), aliyunOssConfig.getYunPath(), new File(aliyunOssConfig.getLocalPath()));
        ossClient.shutdown();
        return putObjectResult.getETag();
    }

    /**
         * @Description: 功能描述：将阿里云文件 下载到本地
         * @author: 杨帆
         * @Param:   阿里云文件的存储位置及文件名 "goat/222.rar"   下载到本地的路径及文件名 "D:/123/321.rar"
         * @Return:
         * @Date:   2018/8/23
    */
    public static String downloadOss(AliyunOssConfig aliyunOssConfig) throws OSSException, ClientException {
        OSSClient ossClient = new OSSClient(aliyunOssConfig.getEndPoint() , aliyunOssConfig.getAccessKey(), aliyunOssConfig.getSecretKey());
        ObjectMetadata temp = ossClient.getObject(new GetObjectRequest(aliyunOssConfig.getBucket(), aliyunOssConfig.getYunPath()),new File(aliyunOssConfig.getLocalPath()));
        ossClient.shutdown();
        return temp.getETag();
    }

    /**
         * @Description: 功能描述： 删除阿里云上文件
         * @author: 杨帆
         * @Param:   唯一参数  要删除文件  在阿里云上的存放位置
         * @Return:
         * @Date:   2018/8/23
    */
    public static void deleteOss(AliyunOssConfig aliyunOssConfig) throws OSSException, ClientException {
        OSSClient ossClient = new OSSClient(aliyunOssConfig.getEndPoint() , aliyunOssConfig.getAccessKey(), aliyunOssConfig.getSecretKey());
        ossClient.deleteObject(aliyunOssConfig.getBucket(),aliyunOssConfig.getYunPath());
        ossClient.shutdown();
    }

    /**
         * @Description: 功能描述：判断 阿里云上 指定文件是否存在
         * @author: 杨帆
         * @Param:    唯一参数  要查找文件  在阿里云上的存放位置
         * @Return:
         * @Date:   2018/8/23
    */
    public static boolean isExistOss(AliyunOssConfig aliyunOssConfig) throws OSSException, ClientException {
        OSSClient ossClient = new OSSClient(aliyunOssConfig.getEndPoint() , aliyunOssConfig.getAccessKey(), aliyunOssConfig.getSecretKey());
        boolean found = ossClient.doesObjectExist(aliyunOssConfig.getBucket(), aliyunOssConfig.getYunPath());
        return found;
    }

}
