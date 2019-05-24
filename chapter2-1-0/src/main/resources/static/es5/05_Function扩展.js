/**
 1. Function.prototype.bind(obj) :
 * 作用: 将函数内的this绑定为obj, 并返回一个新的函数（此时this已经改变），并没有进行调用
 2. 面试题: 区别bind()与call()和apply()?
 * 都能指定函数中的this
 * call()/apply()是立即调用函数
 * bind()是将函数返回
*/
  
  let p1 = { name:'kobe',age:18 }
  let p2 = { name:'jordan',age:23 }

  function demo() {
    console.log(this.name,this.age)
  }

  demo.call(p1) // kobe 18
  demo.apply(p2) // jordan 23


  let demo2 = demo.bind(p2) // 将函数内的this绑定为obj, 并返回一个新的函数（此时this已经改变），并没有进行调用
  demo2() // jordan 23

/** call()/apply()是立即调用函数 */
function foo(data) {
    console.log(this,data)
}

foo.call(p1,33) // 直接从第二个参数开始 依次传入参数

foo.apply(p1,[33]) // 第二个参数必须是数组，传入参数必须放在数组里