for (let i = 0; i < 10; i++) {}
console.log(i)  // 输出10，因为for循环没有块作用域

/**
 for (let k = 0; k < 10; k++) {}
 console.log(k)  // 报错 ReferenceError: k is not defined ，因为let形成块作用域，在外面访问不到
*/

/* 扩展运算符写作三个点（...），可以把一个可遍历的对象解开，转为用逗号分隔的序列 */
console.log(...[1, 2, 3]) // 1 2 3
console.log(1, ...[2, 3, 4], 5) // 1 2 3 4 5

/* Array.from方法用于将可遍历的对象转化为数组 */
function foo() {
    console.log(Array.from(arguments)) // arguments 对象
}
foo(1, 2, 3) // [1, 2, 3]


/* Array.prototype.find方法用于查找数组中第一个符合要求的值 */
let arr = [1, 4, -5, 1];
let temp = arr.find(function (x) {
    return x > 3
})
console.log(temp)

/* Array.prototype.includes方法用来判断数组中是否含有某个值，含有就返回true，否则返回false */
console.log([1, 2, 3].includes(2));     // true
console.log([1, 2, 3].includes(4));     // false
