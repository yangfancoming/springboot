package com.goat.chapter861.hdfs.controller;

import com.goat.chapter861.hdfs.util.HdfsUtils;
import org.apache.hadoop.fs.FileSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class HdfsController {

//    @Autowired
//    FileSystem fileSystem;

    /**
     * 查看节点信息
     */
    @GetMapping("/getdatanodes")
    public List<Map<String, Object>> HdfsNodeInfo() throws Exception {
        System.out.println(11111111);
        List<Map<String, Object>> nodeInfo = HdfsUtils.getNodeInfo();
        return nodeInfo;
//        return null;
    }

}
