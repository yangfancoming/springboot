/**
 Promise对象有以下两个特点。

 （1）对象的状态不受外界影响。Promise对象代表一个异步操作，
 有三种状态：pending（进行中）、fulfilled（已成功）和rejected（已失败）。
 只有异步操作的结果，可以决定当前是哪一种状态，任何其他操作都无法改变这个状态。
 这也是Promise这个名字的由来，它的英语意思就是“承诺”，表示其他手段无法改变。

 （2）一旦状态改变，就不会再变，任何时候都可以得到这个结果。
 Promise对象的状态改变，只有两种可能：从pending变为fulfilled和从pending变为rejected。
 只要这两种情况发生，状态就凝固了，不会再变了，会一直保持这个结果，这时就称为 resolved（已定型）。
 如果改变已经发生了，你再对Promise对象添加回调函数，也会立即得到这个结果。
 这与事件（Event）完全不同，事件的特点是，如果你错过了它，再去监听，是得不到结果的。
*/


// 1.实例一个Promise对象 ：注意 111 222 333 的执行顺序！
let myPromise = new Promise((resolve,reject)=> {
    // 2.Promise 进入初始化状态 pending
    console.log(111)
    // 3.执行异步操作： 通常是 发送ajax请求 或  开启定时器
    setTimeout(()=>{
        console.log(333)
        // 4. 根据异步任务的返回结果 修改 Promise 的状态 （ 尝试 resolve()和 reject() 交替注释 查看效果 ）
        // resolve(9527) // 表示异步调用成功 修改 Promise 的状态为 fullfilled  myPromise 监听到状态改变 自动调用成功回调函数
        reject(9529)  // 表示异步调用失败 修改 Promise 的状态为 rejected    myPromise 监听到状态改变 自动调用失败回调函数

    },1000)
})

console.log(222)

//检测状态的第一种写法
myPromise.then((res)=>{  //成功的回调
    console.log('第一种方式：成功了',res)
},(err)=>{ //失败的回调
    console.log('第一种方式失败了',err)
})

//检测状态的第二种写法
myPromise
    .then((data)=>{
        console.log('第二种方式：成功了',data)
    })
    .catch((err)=>{
        console.log('第二种方式失败了',err)
    })