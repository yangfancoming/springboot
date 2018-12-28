package com.goat;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
     * @Description: 功能描述：(这里用一句话描述这个方法的作用)
     * @author: 杨帆
     * @Param: 
     * @Return: 
     * @Date:   2018/12/27
*/
@SpringBootApplication
@EnableBatchProcessing
public class BatchApplication {
    public static void main(String[] args)  {
        SpringApplication.run(BatchApplication.class, args);
    }
}
