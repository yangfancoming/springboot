/**
 * 箭头函数：
 * 作用: 定义匿名函数（不一定非要定义匿名的函数）
 * 基本语法:
 * 没有参数: () => console.log('xxxx')
 * 一个参数: i => i+2
 * 大于一个参数: (i,j) => i+j
 * 关于函数体需要注意的：
 *     1.函数体不用大括号: 默认返回结果
 *     2.函数体如果有多个语句, 需要用{}包围，若有需要返回的内容，需要手动返回
 * 使用场景: 多用来定义回调函数

 * 箭头函数的特点：
 1、简洁
 2、箭头函数没有自己的this，箭头函数的this不是调用的时候决定的，而是在定义的时候，其所处的上下文对象就是它的this
 3、扩展理解：箭头函数的this看外层的是否有函数，
 如果有，外层函数的this就是内部箭头函数的this，
 如果没有，则this是window。
*/

  function demo1() {
    console.log('传统函数的定义')
  }
  demo1()
  
  let demo2 = () => {
    console.log(`1.箭头左边---没有参数`)
  }
  demo2()

  let demo3 = a => {
    console.log(`2.箭头左边---有一个参数--------能省略小括号`,a)
  }
  demo3(20)

  let demo4 = (a,b,c) => {
    console.log(`3.箭头左边---有多个参数-------不能省略小括号`,a,b,c)
  }
  demo4(20,23,45)
  
  //4.箭头右侧，如果只有一行语句：{}可以省略，如果省略了{}自动帮你返回这行语句的执行结果
  //如果有多行语句，{}不能省略,如果想返回，需要手动返回
  let demo5 = (a,b)=> a+b
  let res = demo5(1,1)
  console.log(res)
  
  
  let test0 = ()=>{
    console.log(this)
    let test1 = ()=>{
      console.log(this)
    }
    window.test1 = test1
  }
  test0()//window
  test1()//window
  
  
  let person = {
    name:'kobe',
    age:18,
    getInfo:function () {
      console.log('第一次输出：',this.name,this.age)
      let test = ()=> {
        console.log('第二次输出：',this.name,this.age)
      }
      window.test = test
    }
  }

  person.getInfo()
  test()
  
  let btn = document.getElementById('btn')
  
  btn.onclick = ()=> {
    console.log(this)
  }
  
  (()=>{
    alert(1)
  })()
  
  
  let demo002 = (a,b)=> {
    return a+b
  }
  
  let res = demo002(1,2)
  console.log(res);
  

