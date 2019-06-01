package a01

/**
  * Created by 64274 on 2018/12/3.
  *
  * @Description:  Scala 函数
  * @author 山羊来了
  * @date 2018/12/3---21:58
  */
object FunctionApp {

  def main(args: Array[String]): Unit = {
    print(add(2,3))
    print(haha)   // 函数没有参数的时候  可以直接用函数名 进行调用
    sayHi  // 调用无返回值函数
    sayName()
  }

  def add(x:Int , y:Int):Int = {
    x+y //最后一行就是返回值  无需 return
  }

  def haha() = 1+2  //  若函数内代码只有一行  可以省略 大括号

  def sayHi():Unit = print("123")

  // 带有参数默认值的函数
  def sayName(name:String = "PK"):Unit = {
    print(name)
  }
}
