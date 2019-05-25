
/**
 async函数(源自ES7)
 概念： 真正意义上去解决异步回调的问题，同步流程表达异步操作
 语法：
 async function foo(){
        await 异步操作;
        await 异步操作；
      }
 特点：
 1、async函数返回的总是Promise对象，可以用then方法进行下一步操作
 2、语意上更为明确，使用简单，经临床验证，暂时没有任何副作用
*/


async function foo() {
    return new Promise(resolve => {
        // setTimeout(function () {
        //     resolve()
        // },2000)
        setTimeout(resolve,2000)
    })
}

async function test() {
    console.log('开始执行',new Date().toTimeString())
    await foo()
    console.log('执行完毕',new Date().toTimeString())
}
test();