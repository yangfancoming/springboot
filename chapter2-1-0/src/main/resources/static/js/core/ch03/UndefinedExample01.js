

let message;
console.log(message == undefined);    //true


let message1 = undefined;
console.log(message1 == undefined);    //true



let demo1 = () => {
    let message;     //this variable is declared but has a value of undefined
    //make sure this variable isn't declared
    // let age
    console.log(message);  //"undefined"
    console.log(age);      //causes an error
}
demo1()


let demo2 = () => {
    let message;     //this variable is declared but has a value of undefined
    //make sure this variable isn't declared
    // let age
    console.log(typeof message);  //"undefined"
    console.log(typeof age);      //"undefined"
}
demo2()


