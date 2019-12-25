package function

import org.junit.Test

/**
 * Created by 64274 on 2018/6/19.
 */
class Function {

    private fun foo(arg1:String,arg2:Boolean,arg3:Int):Int{
        print("$arg1,$arg2,$arg3")
        return 1
    }

    @Test
    fun testfoo() {
        var value = foo("1",true,3)
        print(value) // 返回 1
    }


    //    当函数只有单个表达式时，可以省略花括号，直接写在=之后，如果返回值类型可由编译器推断出来，也可以省略返回值类型：
    private fun foo2(arg1:String,arg2:Boolean,arg3:Int)= 10//

    @Test
    fun testfoo2() {
        var value =foo2("11",false,33)
        print(value)  // 返回 10
    }
}