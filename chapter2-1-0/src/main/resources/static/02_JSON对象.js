

/**
 1. JSON.stringify(obj/arr) js对象(数组)转换为json对象(数组)
 2. JSON.parse(json) json对象(数组)转换为js对象(数组)
 */

let obj2 = { name:'小猪佩奇',age:18 }
let str = JSON.stringify(obj2)
console.log(str)

let obj = JSON.parse(str)
console.log(obj,obj.name,obj.age)

let arr = [1,2,3,4]
let arrStr = JSON.stringify(arr)
console.log(arrStr)
