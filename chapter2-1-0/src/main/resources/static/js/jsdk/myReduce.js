

/**
 这里可以看出，上面的例子index是从1开始的，第一次的prev的值是数组的第一个值。数组长度是4，但是reduce函数循环3次。
 */
let arr = [1, 2, 3, 4];
let sum = arr.reduce(function(prev, cur, index, arr) {
    console.log(prev, cur, index);
    return prev + cur;
})
console.log(arr, sum);


/**
 这个例子index是从0开始的，第一次的prev的值是我们设置的初始值0，数组长度是4，reduce函数循环4次。
*/
let  arr2 = [1, 2, 3, 4];
let sum2 = arr2.reduce(function(prev, cur, index, arr) {
    console.log(prev, cur, index);
    return prev + cur;
},0) //注意这里设置了初始值
console.log(arr2, sum2);

/**
 结论：如果没有提供initialValue，reduce 会从索引1的地方开始执行 callback 方法，跳过第一个索引。如果提供initialValue，从索引0开始。
*/

/** reduce的 简单用法 */
let  arr3 = [1, 2, 3, 4];
let sum3 = arr3.reduce((x, y)=>x+y)
let mul3 = arr3.reduce((x, y)=>x*y)
console.log( sum3,mul3 ); //求和，10 求乘积，24

/** reduce的 高级用法 */

// （1）计算数组中每个元素出现的次数  doit 没看懂
let names = ['Alice', 'Bob', 'Tiff', 'Bruce', 'Alice'];
let nameNum = names.reduce((pre,cur)=>{
    if(cur in pre){
        pre[cur]++
    }else{
        pre[cur] = 1
    }
    return pre
},{})
console.log(nameNum); //{Alice: 2, Bob: 1, Tiff: 1, Bruce: 1}

// （2）数组去重
let arr4 = [1,2,3,4,4,1]
let newArr4 = arr4.reduce((pre, cur)=>{
    if(!pre.includes(cur)){
        return pre.concat(cur)
    }else{
        return pre
    }
},[])
console.log(newArr4);// [1, 2, 3, 4]

// （3）将二维数组转化为一维
let arr5 = [[0, 1], [2, 3], [4, 5]]
let newArr5 = arr5.reduce((pre, cur)=>{
    return pre.concat(cur)
},[])
console.log(newArr5); // [0, 1, 2, 3, 4, 5]

// （3）将多维数组转化为一维
let arr6 = [[0, 1], [2, 3], [4,[5,6,7]]]
const newArr = function(arr){
    return arr.reduce((pre,cur)=>pre.concat(Array.isArray(cur)?newArr(cur):cur),[])
}
console.log(newArr(arr6)); //[0, 1, 2, 3, 4, 5, 6, 7]

// （4）、对象里的属性求和
let result = [
    { subject: 'math', score: 10 },
    { subject: 'chinese', score: 20 },
    { subject: 'english', score: 30 },
];

let sum7 = result.reduce(function(prev, cur) {
    return cur.score + prev;
}, 0);
console.log(sum7) //60

