

/** 函数f如果是普通函数，在为变量generator赋值时就会执行 */
let demo1 = () => {
    let f = () =>  console.log('普通函数 执行了！')
    let generator = f(); //
}
demo1()


/** 函数f是一个 Generator 函数，就变成只有调用next方法时，函数f才会执行。 */
let demo2 = () => {
    function* f() { console.log('Generator函数 执行了！') }
    let generator = f();
    setTimeout(function () {
        generator.next()
    }, 2000);
}
demo2()







