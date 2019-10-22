package com.goat;


import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.List;


/**
 * Created by 64274 on 2018/7/27.
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Mytest {

    public ZooKeeper zookeeper;
    public Watcher watcher;
    @Before
    public void init() throws IOException {
         watcher= event->{  // 收到事件通知后的回调函数
            System.out.println("receive event："+event);
            System.out.println("receive event："+event.getPath());
            System.out.println("receive event："+event.getState());
            System.out.println("receive event："+event.getType());
             try {
                 zookeeper.getChildren("/", true); // 再次 启动监听
             } catch (KeeperException e) {
                 e.printStackTrace();
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
         };
//        zookeeper  = new ZooKeeper("192.168.136.128", 999999, watcher);
        zookeeper  = new ZooKeeper("192.168.235.207", 999999, watcher);
    }
    @After
    public void close() throws InterruptedException {
        zookeeper.close();
    }
    /**
         * @Description: 功能描述：(这里用一句话描述这个方法的作用)
         * @author: Goat
    connectString：连接服务器列表，已“，”分割。
    sessionTimeOut：心跳检测时间周期(毫秒)
    watcher：事件处理通知器。
    canBereadOnly：标识当前会话是否支持只读。
    sessionId和sessionPasswd：提供连接zookeeper的sessionId和密码，通过这两个确定唯一一台客户端，目的是可以提供重复会话
         * @Date:   2018/10/28
    */
    @Test
    public void getData() throws Exception {
//        final byte[] data = zookeeper.getData("/goat", watcher, null); // 节点名称
        final byte[] data = zookeeper.getData("/goat", false, null); // 节点名称
        String value = new String(data); // 转换 返回值
        System.out.println("get value from zookeeper [" + value + "]");
    }

    /**
         * @Description: 创建节点
         * @author: Goat
         * @Param:  要创建节点的路径，节点的数据，节点的权限，节点的类型
         * @Param:
         * @Return:
         * @Date:   2018/10/28
    */
    @Test
    public void create() throws Exception {
        String temp = zookeeper.create("/nani","test2".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        System.out.println("create node from zookeeper [" + temp + "]");
    }

    // 获取节点信息
    @Test
    public void getChildren() throws Exception {
        List<String> children = zookeeper.getChildren("/", true);
        System.out.println("get node from zookeeper [" + children + "]");
    }


    // 判断指定节点是否存在  如果不存在  则返回 null
    @Test
    public void exists() throws Exception {
        Stat exists = zookeeper.exists("/nan123123i", false);
        System.out.println("create node from zookeeper [" + exists + "]");
    }

    // 删除节点  P1 指定节点路径  P2  -1 表示删除所有版本
    @Test
    public void delete() throws Exception {
        zookeeper.delete("/nani", -1);
    }

    // 设置节点的值
    @Test
    public void setData() throws KeeperException, InterruptedException {
        zookeeper.setData("/nani","i love you".getBytes(),-1);
    }

}
