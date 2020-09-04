package com.dyzwj;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author zhengwenjie
 * @version 1.0.0
 * @ClassName CuratorTest1.java
 * @Description TODO
 * @createTime 2020年08月12日 21:10:00
 */
public class CuratorTest1 {


    public static void main(String[] args) throws Exception {
//        //重试策略
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);

        CuratorFramework client= CuratorFrameworkFactory.builder().connectString("localhost:2181,localhost:2182")
                .sessionTimeoutMs(5000)
                .connectionTimeoutMs(5000)
                .retryPolicy(retryPolicy)
                .namespace("aaa")
                .build();

        //        //静态工厂方法创建客户端
//        CuratorFramework client = CuratorFrameworkFactory.
//                newClient("localhost:2131", 5000, 3000,retryPolicy);


        client.start();
        //创建一个结点，附带初始化内容
//        client.create().forPath("/path","init".getBytes());

        //创建一个节点，指定创建模式
//        client.create().withMode(CreateMode.EPHEMERAL).forPath("/test","context".getBytes());



        client.create().forPath("/path/bbb","init".getBytes());


        //创建一个节点，初始内容为空
//        client.create().forPath("/aa");


    }


}
