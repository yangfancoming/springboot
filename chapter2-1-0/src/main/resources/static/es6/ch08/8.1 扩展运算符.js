
/**
 * 扩展运算符（spread）是三个点（...）。它好比 rest 参数的逆运算，将一个数组转为用逗号分隔的参数序列。
 * 用途
 1. 用来取代arguments 但比 arguments 灵活
 2. 作为扩展运算符使用
 let arr1 = [1,3,5];
 let arr2 = [2,...arr1,6];
 arr2.push(...arr1);
 */

let demo = (...props)=> { props.forEach(x=>console.log(x)) }
demo(1,2,3,4,5,6,7)
demo(1,2,3,)

/**  直接将  arr2 插入 arr1 ！ */
let arr2 = [4,5,6]
let arr1 = [1,2,3,...arr2,7,8,9]
console.log(arr1)


console.log(...[1, 2, 3]) // 1 2 3
console.log(1, ...[2, 3, 4], 5) // 1 2 3 4 5


// 该运算符主要用于函数调用。

let add = (x, y) =>{ return x + y }
console.log(add(...[4,3,2,5])) // 7
console.log(add(...[4,3])) // 7