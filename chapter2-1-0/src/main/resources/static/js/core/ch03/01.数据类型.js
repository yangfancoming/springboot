/**
 1. 分类(2大类)  基本类型 (5种) 和  对象类型 (3种)
 2. 判断
     1.typeof:  返回数据类型的字符串表达 number, string, boolean, undefined, function  object 注意：对于 null 和 数组 都是返回 object
     2.instanceof ：  专门用来判断对象数据的具体类型: Object, Array与Function
     3.=== ：  可以判断: undefined 和 null
*/

/**
 基本(值)类型
 Number: 任意数值
 String: 任意文本
 boolean: true/false
 undefined: undefined
 null: null
*/
let a
console.log(a) // undefined
console.log(a===undefined) // true
console.log(typeof a) // 'undefined'
console.log(typeof a==='undefined') // true

console.log("---------------------------------------------------")

a = 2
console.log(typeof a) // 'number'
a = 'atguigu'
console.log(typeof a) // 'string'
a = true
console.log(typeof a) // 'boolean'
a = null
console.log(typeof a) // 'object'
console.log(a===null) //  true

console.log("---------------------------------------------------")

/**
 对象(引用)类型
 任意对象:  Object
 特别的对象类型: Array (下标/内部数据有序) 和  Function: (可执行)
*/
const b1 = {
    b2: [12, 'abc', console.log]
}
console.log(typeof b1.b2) // object
console.log(b1 instanceof Object) // true
console.log(b1 instanceof Array) // false
console.log(b1.b2 instanceof Array) // true
console.log(b1.b2 instanceof Object) // true
console.log(b1.b2[2] instanceof Function, typeof b1.b2[2]==='function') // true  true
console.log(b1.b2[2] instanceof Object) // true