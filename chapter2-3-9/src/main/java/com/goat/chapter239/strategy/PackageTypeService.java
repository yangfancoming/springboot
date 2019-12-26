package com.goat.chapter239.strategy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Administrator on 2019/11/18.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/11/18---13:51
 */
@Component
public class PackageTypeService {

    public Map<Integer, PackageTypeJudge> map = new ConcurrentHashMap<>();

    public PackageTypeService() {}

    @Autowired
    public PackageTypeService(List<PackageTypeJudge> list) {
        for (PackageTypeJudge temp:list){
            map.put(temp.type(),temp);
        }
    }
}
