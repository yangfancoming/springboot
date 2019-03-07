package com.goat;


import org.testng.annotations.Test;

import java.util.*;
import java.util.stream.Collectors;

/**    在JDK 8中对List按照某个属性分组的代码，超级简单
     * @Description:  list 分组  groupby
     * @Description:  list 过滤  filter
     * @Description:  list 求和
     * @Description:  List转为Ma
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
        /**
         * List -> Map
         * 需要注意的是：
         * toMap 如果集合对象有重复的key，会报错Duplicate key ....
         *  apple1,apple12的id都为1。
         *  可以用 (k1,k2)->k1 来设置，如果有重复的key,则保留key1,舍弃key2
         */
        Map<Integer, Apple> appleMap = list.stream().collect(Collectors.toMap(Apple::getId, a -> a,(k1,k2)->k1));

        // 将集合中的数据按照某个属性求和:
//        BigDecimal totalMoney = list.stream().map(Apple::getMoney).reduce(BigDecimal.ZERO, BigDecimal::add);
//        System.err.println("totalMoney:"+totalMoney);  //totalMoney:17.48

        //计算 数量
        int sum = list.stream().mapToInt(Apple::getNum).sum();
        System.err.println("sum:"+sum);  //sum:100

        //分组
        Map<Integer, List<Apple>> groupBy = list.stream().collect(Collectors.groupingBy(Apple::getId));
        System.err.println("groupBy:"+groupBy);
        //过滤
        List<Apple> filterList = list.stream().filter(a -> a.getName().equals("333")).collect(Collectors.toList());
//        List<MesUpnMsgDto> filterList = miDto.stream().filter(a -> a.getNowNum() > 0L).collect(Collectors.toList());
        System.err.println("filterList:"+filterList);
    }

    @Test
    public void te1st1() {
        Coupon coupon1 = new Coupon(1,100,"优惠券1",1);
        Coupon coupon2 = new Coupon(2,200,"优惠券2",1);
        Coupon coupon3 = new Coupon(3,300,"优惠券3",2);
        Coupon coupon4 = new Coupon(3,400,"优惠券4",2);
        List<Coupon> couponList = Arrays.asList(new Coupon [] {coupon1,coupon2,coupon3,coupon4});

        // 按照某个属性分组  后  再 计算分组中 按照价格属性 求每个分组 价格属性之和！
        Map<Integer, List<Coupon>> resultList1 = couponList.stream().collect(Collectors.groupingBy(Coupon::getCouponId));
        for (int i = 1; i <= resultList1.size(); i++) { // Map循环必须要从1开始！！！
            int sum = resultList1.get(i).stream().mapToInt(Coupon::getPrice).sum();
            System.out.println(sum);
        }


        // 如果分组后，分组内并不想是对象，而是对象的属性，也可以做到的
        Map<Integer, List<String>> resultList2 = couponList.stream().collect(Collectors.groupingBy(Coupon::getCouponId,Collectors.mapping(Coupon::getName,Collectors.toList())));

        Map<Integer, List<Integer>> resultList3 = couponList.stream().collect(Collectors.groupingBy(Coupon::getGroup,Collectors.mapping(Coupon::getPrice,Collectors.toList())));


        System.out.println(resultList1);
        System.out.println(resultList2);
        System.out.println(resultList3);
    }

    @Test
    public void te1st12() {

    }

}
