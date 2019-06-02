
/**
 箭头函数中取消了`arguments`对象，是因为ES6中有了更好的替代方式：扩展运算符
 显然我们输入的参数是逗号分隔的序列，被`...`操作符合成了一个数组，以此可以替代`arguments`对象
 注意，只有`...`操作符写在函数的参数中，才是合并的效果，写在其他地方都是展开的效果
 */
let bar = (...values) =>console.log(values)
bar(1,2,3)


/*  在ES6中，我们可以直接给函数参数设置默认值 */

let log = (x, y = 'World') => console.log(x, y)
log('Hello') // Hello World
log('Hello', 'China') // Hello China
log('Hello', '') // Hello