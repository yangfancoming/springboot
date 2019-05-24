
/**
 简化的对象写法
 * 同名属性值 可以复用
 * 省略方法 :function
 */

let x = 12.5
let y = 34.5

let point = {
    x,y,
    get:function(){ console.log('传统方式',this.x,this.y)},
    getPoint() { console.log('简写方式',this.x,this.y), console.log(typeof this) },
    test1:()=> console.log('test1',x,y),
    test2:()=> console.log('test2',point.x,point.y),
    test3:()=> console.log('test3',this.x,this.y), // sos 这里为什么是 undefined undefined ？？ 因为 this 指向的是 Window
    test4:()=> console.log('test4',this),
    /**  将 js 代码 粘贴到 F12里 回车 会看到
     * test4 Window {postMessage: ƒ, blur: ƒ, focus: ƒ, close: ƒ, frames: Window, …}
     * 说明 this 指向的是 Window
    */
}
console.log(point)
point.getPoint()
point.get()

point.test1()
point.test2()
point.test3()
point.test4()
