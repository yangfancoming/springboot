
/**
 1. Array.prototype.indexOf(value) : 得到值在数组中的第一个下标
 2. Array.prototype.lastIndexOf(value) : 得到值在数组中的最后一个下标
 3. Array.prototype.forEach(function(item, index){}) : 遍历数组
 4. Array.prototype.map(function(item, index){}) : 遍历数组返回一个新的数组，返回加工之后的值
 5. Array.prototype.filter(function(item, index){}) : 遍历过滤出一个新的子数组， 返回条件为true的值
 */
/*
 需求:

 5. 根据arr产生一个新数组,要求数组里的元素都是大于4的
 */

let arr = [2,4,6,8,8,6,4,2,1,3,6]
console.log(arr.indexOf(6),'输出第一个6的下标')
console.log(arr.lastIndexOf(6),'输出最后一个6的下标')

arr.forEach( (item,index,source) => console.log(item,index,source,'输出所有元素的值、下标') )


let test2 = (item)=> { return item + 10 }
let arr2 = arr.map(test2)
console.log(arr2,'根据arr产生一个新数组,要求新数组中的每个元素都比原来大10')


let test1 = (item)=> { return item > 4 }
let arr3 = arr.filter(test1)
console.log(arr3,'根据arr产生一个新数组,要求数组里的元素都是大于4的')

