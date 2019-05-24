

/**
 3. promise 实例对象的3个状态
 * pending: 初始化状态
 * fullfilled: 成功状态
 * rejected: 失败状态
*/


// 1.实例一个Promise对象
let myPromise = new Promise((resolve,reject)=> {
    // 2.Promise 进入初始化状态 pending
    console.log(111)
    // 3.执行异步操作： 通常是 发送ajax请求 或  开启定时器
    setTimeout(()=>{
        console.log(333)
        // 4. 根据异步任务的返回结果 修改 Promise 的状态 （ 尝试 resolve()和 reject() 轮班注释 看效果 ）
        resolve(9527) // 表示异步调用成功 修改 Promise 的状态为 fullfilled  myPromise 监听到状态改变 自动调用成功回调函数
        // reject(9529)  // 表示异步调用失败 修改 Promise 的状态为 rejected    myPromise 监听到状态改变 自动调用失败回调函数

    },1000)
})

console.log(222)

//检测状态的第一种写法
myPromise.then((res)=>{  //成功的回调
    console.log(res,'成功了')
},(err)=>{ //失败的回调
    console.log(err,'失败了')
})

//检测状态的第二种写法
myPromise
    .then((data)=>{
        console.log('成功了',data)
    })
    .catch((err)=>{
        console.log('失败了',err)
    })