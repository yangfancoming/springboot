
/* 基本用法 */

/**
 ES6 之前，不能直接为函数的参数指定默认值，只能采用变通的方法。=====> myLog1
 ES6 允许为函数的参数设置默认值，即直接写在参数定义的后面。  =====>myLog2
 */

let myLog1 = (x, y)=>{ y = y || 'World';console.log(x, y);}
let myLog2 = (x,y='World')=> console.log(x, y);

let demo1 = () => {
    console.log("-----------------------------------------");
    myLog1('Hello') // Hello World
    myLog1('Hello', 'China') // Hello China
    myLog1('Hello', '') // Hello World
    console.log("-----------------------------------------");
    myLog2('Hello') // Hello World
    myLog2('Hello', 'China') // Hello China
    myLog2('Hello', '') // Hello World
    console.log("-----------------------------------------");
}
demo1()


/** 参数变量是默认声明的，所以不能用let或const再次声明。
 function foo(x = 5) {
        let x = 1; // error
        const x = 2; // error
    }
 * */


/** 参数默认值的位置
 * 通常情况下，定义了默认值的参数，应该是函数的尾参数。
 * 因为这样比较容易看出来，到底省略了哪些参数。
 * 如果非尾部的参数设置默认值，实际上这个参数是没法省略的。*/

let f1 = (x=1,y)=> console.log([x, y]);
let f2 = (x, y = 5, z)=> console.log([x, y, z]);
let f3 = (x = 'default', y = '', z = {})=> console.log([x, y, z]);

let demo2 = () => {
    f1() // [1, undefined]
    f1(2) // [2, undefined])
    // f(, 1) /* 报错 */
    f1(undefined, 1) // [1, 1]
    console.log("-----------------------------------------");
    f2() // [undefined, 5, undefined]
    f2(1) // [1, 5, undefined]
    // f(1, ,2)  /* 报错 */
    f2(1, undefined, 2) // [1, 5, 2]
    console.log("-----------------------------------------");
    f3()
    f3(1)
    f3('gg', '178bb67df133c8a21c71c272cc2eeff6')
}
demo2()