/**
 1. 理解:
 * 从对象或数组中提取数据, 并赋值给变量(多个)
 2. 对象的解构赋值
 let {n, a} = {n:'tom', a:12}
 3. 数组的解构赋值
 let [a,b] = [1, 'hello'];
 4. 用途
 * 给多个形参赋值
*/

// 对象的解构赋值
/* 传统 方式 赋值 */
let person = {  name:'jkobe',age:18 }
let a = person.name
let b = person.age
console.log(a,b)

/* 解构赋值 方式 赋值  */
let fzz = {  foo:'haha',bar:66 }
let {foo,bar} = fzz // sos { } 中的变量名必须与 fzz 对象中的属性名称 相同 否则报错
console.log(foo,bar)


// 数组的解构赋值
let arr = [1,5,2]
let [,,c] = arr //sos 只根据 数组对应位置进行解构  和变量名称无关
console.log(c) // 2


// 函数 的解构赋值
let show = ({name})=>console.log(name)
show(person)