package com.goat.chapter861.hdfs.util;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.hdfs.DistributedFileSystem;
import org.apache.hadoop.hdfs.protocol.DatanodeInfo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2020/3/10.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2020/3/10---16:24
 */
public class HdfsUtils {

//    private static final String uri = "hdfs://192.168.211.128:9000";
//    private static final String USER = "hadoopUser";
    private static final Configuration config = new Configuration() ;
//    private static  FileSystem fileSystem = null ;

//    static {
//        try {
//            config.set("fs.defaultFS","hdfs://192.168.211.128:9000");
//            fileSystem = FileSystem.get(config);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    /**
     * 查看节点信息
     */
    public static List<Map<String, Object>> getNodeInfo() throws Exception {
        config.set("fs.defaultFS","hdfs://192.168.211.128:9000");
        FileSystem  fileSystem = FileSystem.get(config);

        // 获取分布式文件系统
        DistributedFileSystem hdfs = (DistributedFileSystem) fileSystem;
        List<Map<String, Object>> nodeInfoList = new ArrayList<>();
        // 获取所有节点
        DatanodeInfo[] datanodeStats = hdfs.getDataNodeStats();
        for (int i = 0; i < datanodeStats.length; i++) {
            DatanodeInfo datanodeStat = datanodeStats[i];
            Map<String, Object> map = new HashMap<>();
            map.put("nodeId", "Node_" + i);
            map.put("nodeHostname", datanodeStat.getHostName());
            map.put("nodeIp", datanodeStat.getIpAddr());
            nodeInfoList.add(map);
        }
        hdfs.close();
        fileSystem.close();
        return nodeInfoList;
    }

}
