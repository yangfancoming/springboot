

/**

 2. 什么时候给变量赋值为null呢?
 var a = null //a将指向一个对象, 但对象此时还没有确定
 a = null //让a指向的对象成为垃圾对象


 3. 严格区别变量类型与数据类型?
 js的变量本身是没有类型的, 变量的类型实际上是变量内存中数据的类型
 变量类型:
 基本类型: 保存基本类型数据的变量
 引用类型: 保存对象地址值的变量
 数据对象
 基本类型
 对象类型
*/

/**
 1. undefined与null的区别?
 undefined代表没有赋值
 null代表赋值了, 只是值为null

*/
let a
console.log(a) // undefined 未赋值的变量

function fn() {}
console.log(fn())  // undeined  调用没有return的函数
console.log(fn.xxx) // undefined 读取对象不存在的属性值

a = null
console.log(a) // null  变量赋值为null
a = {b: null}
console.log(a.b) // null  属性值是null



// 2. 什么时候给变量赋值为null呢?
// 1). 在程序的前面
let b = null  // 起暗示作用: 后面会赋值为对象
// 后面进行计算, 处理产生对象并保存
b = {n: 12, m: 34}

// 2). 在程序的后面
b = null // b指向的对象没有了指向它的引用, 就成为了垃圾对象从而被回收释放
// 问题: b就释放了吗?  没有, b是全局变量, 一直存在


// // 3. 严格区别变量类型与数据类型?
// a = 4
// a = []