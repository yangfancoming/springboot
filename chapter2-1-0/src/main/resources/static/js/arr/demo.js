/**
 Returns `true` if the provided predicate function returns `true` for all elements in a collection, `false` otherwise.
 Use `Array.prototype.every()` to test if all elements in the collection return `true` based on `fn`.
 Omit the second argument, `fn`, to use `Boolean` as a default.
*/
const all = (arr, fn = Boolean) => arr.every(fn);

/** 相当于 jdk8中的 Predicate 将函数作为参数传递 */
let result1 = all([4, 0, 3], x => x > 1); // true

/** doit 使用默认值 fn = Boolean 后的输出结果 怎么解释？ */
let result2 =all([1, 0, 3]); // true
console.log('示例1\n',result1,result2)



/**
 Check if all elements in an array are equal. (检查数组中的所有元素是否相等)
 Use `Array.prototype.every()` to check if all the elements of the array are the same as the first one.
*/
const allEqual = arr => arr.every(val => val === arr[0]); // 由于是检测数组中的素有元素是否相同  所以只判断第一个元素就可以了

let allEqual1 = allEqual([1, 2, 3, 4, 5, 6]); // false
let allEqual2 = allEqual([1, 1, 1, 1]); // true
console.log('示例2\n',allEqual1,allEqual2)



/**
 Returns `true` if the provided predicate function returns `true` for at least one element in a collection, `false` otherwise.
 Use `Array.prototype.some()` to test if any elements in the collection return `true` based on `fn`.
 Omit the second argument, `fn`, to use `Boolean` as a default.
 */
const any = (arr, fn = Boolean) => arr.some(fn);

/** 相当于 jdk8中的 Predicate 将函数作为参数传递 */
let any1 = any([0, 1, 2, 0], x => x >= 2); // true

/** doit 使用默认值 fn = Boolean 后的输出结果 怎么解释？ */
let any2 = any([0, 0, 1, 0]); // true
console.log('示例3\n',any1,any2)


/**
 Converts a 2D array to a comma-separated values (CSV) string.
 Use `Array.prototype.map()` and `Array.prototype.join(delimiter)` to combine individual 1D arrays (rows) into strings.
 Use `Array.prototype.join('\n')` to combine all rows into a CSV string, separating each row with a newline.
 Omit the second argument, `delimiter`, to use a default delimiter of `,`.
*/
const arrayToCSV = (arr, delimiter = ',') => arr
    .map(v => v.map(x => (isNaN(x) ? `"${x.replace(/"/g, '""')}"` : x)).join(delimiter))
    .join('\n');
let arrayToCSV1 = arrayToCSV([['a', 'b'], ['c', 'd']]);
let arrayToCSV2 =arrayToCSV([['a', 'b'], ['c', 'd']], ';');
let arrayToCSV3 =arrayToCSV([['a', '"b" great'], ['c', 3.1415]]);
console.log('示例4\n',arrayToCSV1,'\n')
console.log('示例4\n',arrayToCSV2,'\n')
console.log('示例4\n',arrayToCSV3,'\n')


/**  有点小难  有点小绕
 Creates a function that accepts up to `n` arguments, ignoring any additional arguments.
 Call the provided function, `fn`, with up to `n` arguments, using `Array.prototype.slice(0,n)` and the spread operator (`...`).
 Math.max : 返回给定的一组数字中的最大值
 */
const test = (fn, n) => (...args) => fn(...args.slice(0, n));
const firstTwoMax = test(Math.max, 2);
let map = [[2, 6, 'a'], [8, 4, 6], [10]].map(x => firstTwoMax(...x)); // [6, 8, 10]
console.log('示例5\n',map,'\n')

/**
 Decodes a string of data which has been encoded using base-64 encoding.
 Create a `Buffer` for the given string with base-64 encoding and use `Buffer.toString('binary')` to return the decoded string.
*/
const atob = str => Buffer.from(str, 'base64').toString('binary');
console.log(atob('Zm9vYmFy')) // 'foobar'

/**
 Creates a base-64 encoded ASCII string from a String object in which each character in the string is treated as a byte of binary data.
 Create a `Buffer` for the given string with binary encoding and use `Buffer.toString('base64')` to return the encoded string.
*/
const btoa = str => Buffer.from(str, 'binary').toString('base64');
console.log(btoa('foobar')) // 'Zm9vYmFy'










































