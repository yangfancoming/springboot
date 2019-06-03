
// ES6 提供了二进制和八进制数值的新的写法，分别用前缀0b（或0B）和0o（或0O）表示。
console.log(0b111110111 === 503) // true
console.log(0o767 === 503) // true

// 如果要将0b和0o前缀的字符串数值转为十进制，要使用Number方法。
console.log(Number('0b111'))  // 7
console.log(Number('0o10'))  // 8

/**
 ES6 在Number对象上，新提供了Number.isFinite()和Number.isNaN()两个方法。
 Number.isFinite()用来检查一个数值是否为有限的（finite），即不是Infinity。
 注意，如果参数类型不是数值，Number.isFinite一律返回false。
*/

console.log(Number.isFinite(15)); // true
console.log(Number.isFinite(0.8)); // true

console.log( Number.isFinite(NaN) ); // false
console.log(Number.isFinite(Infinity) ) ; // false
console.log(Number.isFinite(-Infinity) ); // false
console.log( Number.isFinite('foo')); // false
console.log( Number.isFinite('15')) ; // false
console.log( Number.isFinite(true)) ; // false





