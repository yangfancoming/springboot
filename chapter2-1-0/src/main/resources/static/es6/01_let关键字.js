
/**
 let
 1. 作用: 与var类似, 用于声明一个变量
 2. 特点:
 * 在块作用域内有效
 * 不能重复声明
 * 不会预处理, 不存在提升
 3. 应用:
 * 循环遍历加监听
 * 使用let取代var是趋势
*/

//先使用后定义 ： var 只声明不定义  function 既声明又定义
console.log(a) // undefined
console.log(getA) // [Function: getA]
console.log(b) // 直接报错： b is not defined
var a = 1;
function getA() {}

let b = 1;