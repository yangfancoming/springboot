package com.goat;


import org.junit.Test;

/**
     * @Description: 功能描述：jedis 对list的操作
     * @author: 杨帆
     * @Date:   2018/9/27
在Redis中，List类型是按照插入顺序排序的字符串链表。和数据结构中的普通链表一样，我们可以在其头部(left)和尾部(right)添加新的元素。
在插入时，如果该键并不存在，Redis将为该键创建一个新的链表。
与此相反，如果链表中所有的元素均被移除，那么该键也将会被从数据库中删除
*/
public class Redis_List extends Redis_Common {

    @Test
    public void rpush(){
        // 从list的右边插入元素(插入的value值可以是一个或多个)：
        jedis.rpush("key","value1","value2","value3");
    }

    @Test
    public void lpush(){
        //从list的左边插入元素(插入的value值可以是一个或多个)：
        jedis.lpush("key","value1","value2","value3");
    }

    @Test
    public void llen(){
        //   返回指定Key关联的链表中元素的数量，如果该Key不存在，则返回0
        jedis.llen("key");
    }

    /**
     返回指定范围内元素的列表。其中start的值也可以为负值，-1将表示链表中的最后一个元素，即尾部元素，-2表示倒数第二个并以此类推。
     该命令在获取元素时，start和end位置上的元素也会被取出。
     如果start的值大于链表中元素的数量，空链表将会被返回。
     如果end的值大于元素的数量，该命令则获取从start(包括start)开始，链表中剩余的所有元素
     */
    @Test
    public void lrange(){
        jedis.lrange("key",2,6);
    }


    /**
     该命令将仅保留指定范围内的元素，从而保证链接中的元素数量相对恒定。start和stop也可以为负值，-1表示尾部元素。
     如果start大于链表的尾部，或start大于stop，该命令不错报错，而是返回一个空的链表，与此同时该Key也将被删除。
     如果stop大于元素的数量，则保留从start开始剩余的所有元素。
     */
    @Test
    public void ltrim(){
        jedis.ltrim("key",3,7);
    }

    @Test
    public void lindex(){
        // 返回链表中指定位置(index)的元素，0表示头部元素，如果index为-1，表示尾部元素
        jedis.lindex("key",2);
    }

    @Test
    public void lset(){
        // 给链表中指定位置的值替换为新值，0表示头部元素，如果index为-1，表示尾部元素
        jedis.lset("key",2,"newValue");
    }

    /**
     在指定Key关联的链表中，删除前count个值等于value的元素。
     如果count大于0，从头向尾遍历并删除，如果count小于0，则从尾向头遍历并删除。
     如果count等于0，则删除链表中所有等于value的元素。
     如果指定的Key不存在，则直接返回0,返回被删除的元素数量
     */
    @Test
    public void lrem(){
        jedis.lrem("key",2,"2222");
    }

    @Test
    public void rpop(){
        // 从指定list按顺序取出元素(从右边)，返回取出的元素
        jedis.rpop("key");
    }
    @Test
    public void lpop(){
        // 从指定list按顺序取出元素(从左边)，返回取出的元素：
        jedis.rpop("key");
    }

}
