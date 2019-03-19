package com.goat.fkfb.controller;


import com.dangdang.ddframe.rdb.sharding.keygen.KeyGenerator;
import com.goat.fkfb.entity.Goods;
import com.goat.fkfb.repository.GoodsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * @author yangyang
 * @date 2019/1/29
 */
@RestController
public class GoodsController {

    @Autowired
    private KeyGenerator keyGenerator;

    @Autowired
    private GoodsRepository goodsRepository;
    //   http://localhost:8477/save
    @GetMapping("save")
    public String save(){
        for(int i= 1 ; i <= 40 ; i ++){
            Goods goods = new Goods();
            goods.setGoodsId((long) i);
            goods.setGoodsName( "shangpin" + i);
            goods.setGoodsType((long) (i+1));
            goodsRepository.save(goods);
        }
        return "success";
    }
    // http://localhost:8477/select
    @GetMapping("select")
    public List<Goods> select(){
        List<Goods> all = goodsRepository.findAll();
        return all;
    }

    @GetMapping("delete")
    public void delete(){
         goodsRepository.deleteAll();
    }

    @GetMapping("query1")
    public List<Goods> query1(){
        List<Goods> allByGoodsIdBetween = goodsRepository.findAllByGoodsIdBetween(10L, 30L);
        return allByGoodsIdBetween;
    }

    @GetMapping("query2")
    public List<Goods> query2(){
        List<Long> goodsIds = Arrays.asList(10L,15L,20L,25L);
        List<Goods> allByGoodsIdIn = goodsRepository.findAllByGoodsIdIn(goodsIds);
        return allByGoodsIdIn;
    }
}
