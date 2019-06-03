

let demo1 = () => {
    let oldValue = 64;               //equal to binary 1000000
    let newValue = oldValue >> 5;    //equal to binary 10 which is decimal 2
    console.log(newValue);//2
}
demo1()

let demo2 = () => {

    let oldValue = -64;              //equal to binary -1000000
    let newValue = oldValue >> 5;    //equal to binary -10 which is decimal -2
    console.log(newValue);
}
demo2()


let demo3 = () => {
    let oldValue = 64;               //equal to binary 1000000
    let newValue = oldValue >>> 5;   //equal to binary 10 which is decimal 2
    console.log(newValue);                // 2
}
demo3()

let demo4 = () => {
    let oldValue = -64;              //equal to binary 11111111111111111111111111000000
    let newValue = oldValue >>> 5;   //equal to decimal 134217726
    console.log(newValue);                 //134217726

}
demo4()