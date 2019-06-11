/**
 常用于 ：
 1.闭包
 2.插件

 简单的说，闭包就是有权限访问另一个函数内部作用域的变量的函数；
 javascript具有自动垃圾回收机制，函数运行完之后，其内部的变量和数据会被销毁；
 但是闭包就是在外部可以访问此函数内部作用域的变量，所以闭包的一个特点就是只要存在引用函数内部变量的可能，
 JavaScript就需要在内存中保留这些变量。而且JavaScript运行时需要跟踪这个内部变量的所有外部引用，
 直到最后一个引用被解除（主动把外部引用赋为null或者页面关闭），JavaScript的垃圾收集器才能释放相应的内存空间；
 */

function outer(){
    var a = 1;
    function inner(){
        return a++;
    }
    return inner;
}
var abc = outer();
//outer()只要执行过，就有了引用函数内部变量的可能，然后就会被保存在内存中；
//outer()如果没有执行过，由于作用域的关系，看不到内部作用域，更不会被保存在内存中了；

//因为a已经在内存中了，所以再次执行abc()的时候，是在第一次的基础上累加的
console.log(abc());//1
console.log(abc());//2
console.log(abc());//3

//再次把outer()函数赋给一个新的变量def，相当于绑定了一个新的outer实例；
var def = outer();
console.log(def());//1
console.log(def());//2


//由于作用域的关系我们在外部还是无法直接访问内部作用域的变量名和函数名
// console.log(a);//ReferenceError: a is not defined
// console.log(inner);//ReferenceError: a is not defined

//由于闭包占用内存空间，所以要谨慎使用闭包。尽量在使用完闭包后，及时解除引用，释放内存；
abc = null;

/** 立即执行函数能配合闭包保存状态 */
console.log('---------------------------------------------');
for(var i = 0; i < 3; i++){
    setTimeout(function(){
        console.log(i);    //3 3 3
        //在执行到这一行时，发现匿名函数里没有i，然后向往外部作用域找，然后找到的其实是for循环执行完了的i，也就是2++ = 3
    },0);
};


