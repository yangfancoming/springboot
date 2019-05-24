/**
 * 用途
 1. 用来取代arguments 但比 arguments 灵活
 2. 作为扩展运算符使用
 let arr1 = [1,3,5];
 let arr2 = [2,...arr1,6];
 arr2.push(...arr1);
 */

let demo = (...props)=> { props.forEach(x=>console.log(x)) }
demo(1,2,3,4,5,6,7)

/**  直接将  arr2 插入 arr1 ！ */
let arr2 = [4,5,6]
let arr1 = [1,2,3,...arr2,7,8,9]
console.log(arr1)


