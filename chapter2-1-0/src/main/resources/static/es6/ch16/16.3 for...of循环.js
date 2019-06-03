/**
 for...of循环可以自动遍历 Generator 函数时生成的Iterator对象，且此时不再需要调用next方法
 下面代码使用for...of循环，依次显示 5 个yield表达式的值。
 这里需要注意，一旦next方法的返回对象的done属性为true，for...of循环就会中止，
 且不包含该返回对象，所以上面代码的return语句返回的6，不包括在for...of循环之中。
*/
function* foo() {
    yield 1;
    yield 2;
    yield 3;
    yield 4;
    yield 5;
    return 6;
}

for (let v of foo()) {
    console.log(v);
}
// 1 2 3 4 5