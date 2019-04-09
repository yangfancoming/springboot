package collection

import org.junit.Test

/**
 * Created by 64274 on 2018/6/19.
 *
 *  不可修改的集合 API 包括 List 、 Set 、 Map 等；
 *  可修改集合的   API 包括 MutableList、 MutableSet、 MutableMap 等，
 */
class CreateCollection {

//    val set = hashSetOf(1, 7, 53)
//    val list = arrayListOf(1, 7, 53)
//    val map = hashMapOf(1 to "one", 7 to "seven", 53 to "fifty-three")

    @Test
    fun listOf() {
        val readOnly = listOf(1,2,3)
        println(readOnly)
        println(readOnly.last())
    }
    @Test
    fun mutableListOf() {
        val mutable = mutableListOf(1,2,3,4)
        println(mutable) // 输出 "[1, 2, 3, 4]"
        println(mutable.last())  // 输出 4
        println(mutable.clear())

    }
    @Test
    fun setOf() {
        val numbers = setOf(1, 14, 2)
        println(numbers.max())
    }

    @Test
    fun mapOf() {
// 创建 Map 对象
    }
}