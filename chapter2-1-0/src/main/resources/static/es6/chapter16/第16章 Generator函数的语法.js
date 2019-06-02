
/**
 Generator 函数是一个普通函数，但是有两个特征。
 一是，function关键字与函数名之间有一个星号；
 二是，函数体内部使用yield表达式，定义不同的内部状态（yield在英语里的意思就是“产出”）。
*/
function* helloWorldGenerator() {
    yield 'hello';
    yield 'world';
    return 'ending';
}
/**
 Generator 函数的调用方法与普通函数一样，也是在函数名后面加上一对圆括号。
 不同的是，调用 Generator 函数后，该函数并不执行，返回的也不是函数运行结果，
 而是一个指向内部状态的指针对象，也就是上一章介绍的遍历器对象（Iterator Object）。
 下一步，必须调用遍历器对象的next方法，使得指针移向下一个状态。
 也就是说，每次调用next方法，内部指针就从函数头部或上一次停下来的地方开始执行，直到遇到下一个yield表达式（或return语句）为止。
 换言之，Generator 函数是分段执行的，yield表达式是暂停执行的标记，而next方法可以恢复执行。
*/
let hw = helloWorldGenerator();

/**
 第一次调用，Generator 函数开始执行，直到遇到第一个yield表达式为止。
 next方法返回一个对象，它的value属性就是当前yield表达式的值hello，done属性的值false，表示遍历还没有结束。
*/
console.log(hw.next()) // { value: 'hello', done: false }

/**
 第二次调用，Generator 函数从上次yield表达式停下的地方，一直执行到下一个yield表达式。
 next方法返回的对象的value属性就是当前yield表达式的值world，done属性的值false，表示遍历还没有结束。
 */
console.log(hw.next()) // { value: 'world', done: false }

/**
 第三次调用，Generator 函数从上次yield表达式停下的地方，一直执行到return语句（如果没有return语句，就执行到函数结束）。
 next方法返回的对象的value属性，就是紧跟在return语句后面的表达式的值（如果没有return语句，则value属性的值为undefined），done属性的值true，表示遍历已经结束。
 */
console.log(hw.next()) // { value: 'ending', done: true }

/**
 第四次调用，此时 Generator 函数已经运行完毕，next方法返回对象的value属性为undefined，done属性为true。以后再调用next方法，返回的都是这个值。
 */
console.log(hw.next()) // { value: undefined, done: true }





