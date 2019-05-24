
// 共用数据源
let arr = [1, 2, 3, 4];
let test = function add(prev, cur, index, arr) {
    console.log(prev, cur, index,arr);
    return prev + cur;
};

/** 这里可以看出，上面的例子index是从1开始的，第一次的prev的值是数组的第一个值。数组长度是4，但是reduce函数循环3次。*/
let sum1 = arr.reduce(test)
console.log('结果为：'+ sum1);

/** 这个例子index是从0开始的，第一次的prev的值是我们设置的初始值0，数组长度是4，reduce函数循环4次。*/
let sum2 = arr.reduce(test,0)
console.log('结果为：'+ sum2);

/**
 结论：如果没有提供initialValue，reduce 会从索引1的地方开始执行 callback 方法，跳过第一个索引。如果提供initialValue，从索引0开始。
 */

/** reduce的 简单用法 */
let sum3 = arr.reduce((x, y)=>x+y)
let mul3 = arr.reduce((x, y)=>x*y)
console.log( sum3,mul3 ); //求和，10 求乘积，24

/** reduce的 高级用法 */

// （1）计算数组中每个元素出现的次数  doit 没看懂
let names = ['Alice', 'Bob', 'Tiff', 'Bruce', 'Alice'];
let gaga = (prev,cur)=>{
    if(cur in prev)
        prev[cur]++
    else
        prev[cur] = 1
    return prev
}
let nameNum = names.reduce(gaga,{})
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
// let hoho = (pre,cur)=> {return cur.score + prev}; // doit  这种方式为啥不行？
let hoho = function(prev, cur) {
    return cur.score + prev;
};

let sum7 = result.reduce(hoho,0);
console.log(sum7) //60


/**
 Returns the average of two or more numbers.
 Use `Array.prototype.reduce()` to add each value to an accumulator, initialized with a value of `0`, divide by the `length` of the array.
*/
const average = (...nums) => nums.reduce((acc, val) => acc + val, 0) / nums.length ;
let average1 = average(...[1, 2, 3]);
let average2 = average(1, 2, 9);
console.log(average1,average2) //  2 4