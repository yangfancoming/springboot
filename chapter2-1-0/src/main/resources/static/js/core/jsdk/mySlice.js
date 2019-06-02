

/** slice() 用于截取数组，并返回截取到的新的数组，数组与字符串对象都使用（⚠️：对原数组不会改变）
 参数：
 　　start: 必需。规定从数组（字符串）的哪个index开始选取，如果是负数，则从数组（字符串）尾部算index，比如，-1指最后一个元素，-2指倒数第二个元素。
 　　end:可选。规定到哪个index之前结束。如果没有指定该参数，那么切分的数组（字符串）包含从start到数组（字符串）结束的所有元素。如果这个参数是负数，那么它规定的是从数组（字符串）尾部开始算起的元素。
 返回值：
 　　返回一个新的数组（字符串），包含从start到end（不包含改元素）的obj中的元素。
 说明：
 　　该方法并不会修改数组（字符串），而是返回一个子数组（子串）。
 */

let arr0 = [1,2,3,4];
let del = arr0.slice(1,2)//从下标为1的位置删除，删除两个元素（不包括下标为2的元素）2
let del0 = arr0.slice(1,3)//
let del1 = arr0.slice(-1)//为元素的最后一位 4
let del2 = arr0.slice(-6)//当只传入一个参数，而且是负数，length与参数相加  1,2,3,4
let del3 = arr0.slice(1,-2)//当传入的参数为一正一负时，length会先与负数相加在截取  2
let del4 = arr0.slice(6)//当传入的参数大于length，返回一个空数组 []
console.log(del,del0,del1,del2,del3,del4)

let str="蚂蚁部落欢迎您，softwhy.com";
console.log(str.slice(2));
console.log(str.slice(2,5));//（不包括下标为5的元素）