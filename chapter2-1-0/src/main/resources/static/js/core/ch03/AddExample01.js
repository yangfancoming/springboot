

let demo1 = () => {
    let result1 = 5 + 5;     //two numbers
    console.log(result1);           //10
    let result2 = 5 + "5";   //a number and a string
    console.log(result2);           //"55"
}
demo1()

let demo2 = () => {
    let num1 = 5;
    let num2 = 10;
    let message = "The sum of 5 and 10 is " + num1 + num2;
    console.log(message);    //"The sum of 5 and 10 is 510"
}
demo2()


let demo3 = () => {
    let num1 = 5;
    let num2 = 10;
    let message = "The sum of 5 and 10 is " + (num1 + num2);
    console.log(message);    //"The sum of 5 and 10 is 15"
}
demo3()



