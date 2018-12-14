package com.goat;


import org.testng.annotations.Test;

import java.util.*;
import java.util.stream.Collectors;


/**
     * @Description:
     * @author: 杨帆
     * @Date:   2018/12/14
*/
public class TestNG {

    @Test
    public void test0()  { // 从输出结果看,数据已经按照skuId进行分组了
        /*1、准备数据**/
        SkuVo sku1 = new SkuVo(1L,"p1",100L);
        SkuVo sku2 = new SkuVo(2L,"p2",101L);
        SkuVo sku3 = new SkuVo(3L,"p3",102L);
        SkuVo sku4 = new SkuVo(3L,"p4",103L);
        SkuVo sku5 = new SkuVo(2L,"p5",100L);
        SkuVo sku6 = new SkuVo(5L,"p6",100L);

        List<SkuVo> skuVoList = Arrays.asList(new SkuVo [] {sku1,sku2,sku3,sku4,sku5,sku6});

        /*2、分组算法**/
        Map<Long, List<SkuVo>> map = new HashMap<>();
        for (SkuVo skuVo : skuVoList) {
            List<SkuVo> tempList = map.get(skuVo.getSkuId());
            /*如果取不到数据,那么直接new一个空的ArrayList**/
            if (tempList == null) {
                tempList = new ArrayList<>();
                tempList.add(skuVo);
                map.put(skuVo.getSkuId(), tempList);
            }
            else {
                /*某个sku之前已经存放过了,则直接追加数据到原来的List里**/
                tempList.add(skuVo);
            }
        }
        /*3、遍历map,验证结果**/
        for(Long skuId : map.keySet()){
            System.out.println(map.get(skuId));
        }

    }

    @Test
    public void te1st0() {  // List 以ID分组 Map<Integer,List<Apple>>
        Apple apple1 = new Apple(1,"111", 1,11);
        Apple apple2 = new Apple(2,"222", 1,22);
        Apple apple3 = new Apple(3,"333", 1,33);
        Apple apple4 = new Apple(3,"333", 1,44);
        Apple apple5 = new Apple(2,"555", 1,22);

        List<Apple> list = Arrays.asList(new Apple [] {apple1,apple2,apple3,apple4,apple5});
        Map<Integer, List<Apple>> groupBy = list.stream().collect(Collectors.groupingBy(Apple::getId));
        System.err.println("groupBy:"+groupBy);
        //过滤出符合条件的数据
        List<Apple> filterList = list.stream().filter(a -> a.getName().equals("333")).collect(Collectors.toList());
        System.err.println("filterList:"+filterList);
    }

}
