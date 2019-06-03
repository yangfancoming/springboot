
let sayHi1 = (name, message) => console.log("Hello " + name + ", " + message);
sayHi1("Nicholas", "how are you today?");


let sayHi2 = (name, message) => {
    return;
    console.log("Hello " + name + ", " + message); //never called
}
sayHi2("Nicholas", "how are you today?");


let sum = (num1, num2) => num1 + num2;
console.log(sum(5, 10));


let diff = (num1, num2) => num1 < num2 ? num2 - num1:num1 - num2
console.log(diff(7, 10));


let sayHi3 = () => console.log("Hello " + arguments[0] + ", " + arguments[1]);
sayHi3("Nicholas", "how are you today?");




function howManyArgs() {``
    console.log(arguments.length);
}

howManyArgs("string", 45);    //2
howManyArgs();                //0
howManyArgs(12);              //1



function doAdd() {
    if(arguments.length == 1) {
        console.log(arguments[0] + 10);
    } else if (arguments.length == 2) {
        console.log(arguments[0] + arguments[1]);
    }
}
doAdd(10);        //20
doAdd(30, 20);    //50




function doAdd(num1, num2) {
    if(arguments.length == 1) {
        console.log(num1 + 10);
    } else if (arguments.length == 2) {
        console.log(arguments[0] + num2);
    }
}
doAdd(10);        //20
doAdd(30, 20);    //50



function doAdd(num1, num2) {
    //if(arguments.length == 1) {
    arguments[1] = 10;
    //}
    console.log(arguments[0] + num2);
}
doAdd(10, 20);        //20
doAdd(30, 20);    //50


// 貌似 使用最后一次定义的函数
let addSomeNumber =  num => num + 100;
let addSomeNumber =  num => num + 200;
console.log(addSomeNumber(100)); //300





















