/**
 常用于 ：
 1.闭包
 2.插件 ： 用立即函数配合闭包写插件，防止变量全局污染，以及保证内部变量的安全；
 */

let Person = (function(){

    let _sayName = function(str){
        str = str || 'shane';
        return str;
    }
    let _sayAge = function(age){
        age = age || 18;
        return age;
    }

    return {
        SayName : _sayName,
        SayAge : _sayAge
    }
})();

//通过插件提供的API使用插件
console.log(Person.SayName('lucy')); //lucy
console.log(Person.SayName());//shane
console.log(Person.SayAge());//18


