/**
 yield表达式本身没有返回值，或者说总是返回undefined。next方法可以带一个参数，该参数就会被当作上一个yield表达式的返回值。
*/

function* f() {
    for(let i = 0; true; i++) {
        let reset = yield i;
        if(reset) { i = -1; }
    }
}

let g = f();
console.log(g.next()) // { value: 0, done: false }
console.log(g.next()) // { value: 1, done: false }
console.log(g.next(true))  // { value: 0, done: false }
