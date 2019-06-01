package chapter01

/**
  * 演示输出字符串的三种方式
  */
object PrintDemo {
  
  def main(args: Array[String]): Unit = {
    val str1 = "hello"
    val str2 = " word"
    println(str1 + str2)
    
    val name = "张三"
    val age = 25
    val height = 175.41f
    val sal = 10000.1235
    
    //格式化输出
    printf("名字=%s 年龄=%d 身高=%.2f 薪水=%.3f", name, age, height, sal)

    //scala支持$输出内容，编译器会去解析$对应的变量
    println(s"\n个人信息如下：\n名字：$name， 年龄：$age，身高：$height, 薪水：$sal")

    //如果在输出中出现了类似 ${age + 10} 的内容，则表示 {} 里面的内容是一个表达式，在执行输出时会参与计算
    println(s"个人信息如下：\n名字：$name， 年龄：${age + 10}，身高：$height, 薪水：${sal * 10}")
    
    
  }
  
}
