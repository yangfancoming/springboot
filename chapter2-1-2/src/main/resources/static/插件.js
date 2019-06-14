

/**  方式一
 (function (global){
    let Table = function () {
        this.test1 = function () { alert("11111111") }
        this.test2 = function () { alert("22222222") }
    }
    global.Table = Table;
})(window);
*/


/**  方式二 */

( (global) => {
    let Table = function () {  // 这里不能使用 lambda表达式 否则报错
        this.test1 =  () => { console.log("11111111") }
        this.test2 = function () { console.log("22222222") }
    }
    Table.prototype.create = (json)=> {
        console.log(json,"33333333")
        let data = json.data;
        let el = json.el;
        for (let key in data){
            console.log(key,data[key]); // row 3 和 col 2
           console.log( parseInt(data[key]),'parseInt') //  parseInt()   参数 什么都不谢 ''    和字母 'AB'   解析结果都是   NaN
            if (!parseInt(data[key])){
                throw "参数有误！"
            }
        }
    }
    global.Table = Table; // 赋值的方法 不能够使用 lambda表达式
})(window);
