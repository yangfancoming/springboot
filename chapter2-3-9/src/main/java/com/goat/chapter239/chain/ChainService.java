package com.goat.chapter239.chain;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ChainService {

    // 包长度处理器
    @Autowired
    PackageLength packageLength;
    // DTU 身份识别码
    @Autowired
    PackageIdentity packageIdentity;
    // ip
    @Autowired
    PackageIp packageIp;
    // port
    @Autowired
    PackagePort packagePort;
    // 用户数据
    @Autowired
    Chain socketUser;

    public Chain getChain(){
        // 设置节之前要先清空各个节点的处理器实例
        packageIdentity.clearSuccessor();
        packageLength.clearSuccessor();
        // 设置责任链 节点处理顺序
        packageLength.setSuccessor(packageIdentity);
        return packageLength;
    }

    public Chain getChain1(){
        // 设置节之前要先清空各个节点的处理器实例
        packagePort.clearSuccessor();
        packageIp.clearSuccessor();
        packageIdentity.clearSuccessor();
        packageLength.clearSuccessor();
        // 设置责任链 节点处理顺序
        packageLength.setSuccessor(packageIdentity).setSuccessor(packageIp).setSuccessor(packagePort);
        return packageLength;
    }

    public Chain getChain09(){
        packageIdentity.clearSuccessor();
        packageLength.clearSuccessor();
        packageLength.setSuccessor(packageIdentity).setSuccessor(socketUser);
        return packageLength;
    }

}
