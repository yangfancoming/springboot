package collection

import org.testng.annotations.Test


/**
 * Created by 64274 on 2018/6/16.
 *
 *
 */
class SetCollection{
    @Test
    fun test1() {
        var set = mutableSetOf<Int>()
        set.add(1)
        set.add(1)
        var size = set.size
        print("size = $size")
    }

    @Test
    fun test2() {
        var set = mutableSetOf<Int>()
        set.add(1)
        set.add(2)
        var size = set.size
        print("size = $size")

        //迭代
        for(item in set){
              print("item = $item")
        }

        var contains = set.contains(1) //是否包含 返回 bool
        print(contains)
        set.remove(1) //  移除 参数为下标索引
        set.clear() //清空
    }

    @Test
    fun test3() {
//        val setTea: Set<String> = setOf("E", "F", "B", "C", "A", "D", "F", "B", "B")
        val setTea: Set<String> = setOf("E", "F", "B", "C", "A", "D", "F", "B", "B")
        for (item in setTea) {
            println(item)
        }
    }
    /*
        从示例代码中，我们可以清晰的看出
    1. Set中没有重复的对象
    2. Set中对象不按特定的方式排序
    */

}