package myclass

import org.testng.annotations.Test

/**
 * Created by 64274 on 2018/6/19.
 */
//class myclass.Person (val name: String,var isMarried: Boolean) //如果主构造器没有任何的注释（ annotation ）或修饰器（ modifier), constructor 关键字可以省略
class Person constructor( val name: String,var isMarried: Boolean) {
    //如果是主构造器， 需要在 init 块中进行初始化
    init {
        println(name+ "primary constructor")
    }
    // 第二构造器（通过 this 直接调用了主构造器）
    constructor(value: Int) : this ("lala" ,false){
        println(value.toString() + "secondary constructor")
    }
}

class Mytest {
    @Test
    fun primary() {
        val person = Person("Bob", true)
        println(person.name)
        println(person.isMarried)
    }

    @Test
    fun secondary() {
        Person(10)
    }
}