package lambda

import org.testng.annotations.Test


/**
 * Created by 64274 on 2018/6/19.
 *
 * Kotlin 中 双冒号操作符 表示把一个方法当做一个参数，传递到另一个方法中进行使用，通俗的来讲就是引用一个方法
 */
class Lambda {

   private fun add(x:Int,y:Int):Int = x+y

    @Test
    fun test1() {
        println(add(1,3))
    }


    private fun operate(x:Int=0,y:Int=0,body:(Int,Int)->Int){ //body是一个函数类型，传入两个Int类型参数，返回一个Int类型参数
        print("this result is "+body(x,y))
    }

    @Test fun test2(){
        operate(3,7,::add)
    }

    @Test fun test3(){
        operate(3,7,{ x,y->x+y })//函数参数传入
    }

    //函数参数作为函数的最后一个参数，并且传入的是一个lambda表达式，可以在在圆括号外指定
    @Test fun test4(){
        operate(3,7){ x,y->x+y }
    }

}