// promise就是前一步完成了动作就执行下一步操作

let flag=200
function one(resolve,reject){
    console.log("one");
    if(flag==200){
        resolve("step1 finish")
    }else{
        reject("step1 erro")
    }
}
function two(resolve,reject){
    console.log("two");
    if(flag==200){
        resolve("step2 finish")
    }else{
        reject("step2 erro")
    }
}
function three(resolve,reject){
    console.log("three");
    if(flag==200){
        resolve("step3 finish")
    }else{
        reject("step3 erro")
    }
}

// new Promise
new Promise(one).then(function(val){
    console.log(val);
    return new Promise(two) // new Promise
}).then(function(val){
    console.log(val);
    return new Promise(three)  // new Promise
}).then(function(val){
    console.log(val);
    return val
})