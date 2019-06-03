

let count = 10;


let demo1 = () => {
    console.log("demo1....................");    //10
    for (let i=0; i < count; i++){
        console.log(i);
    }
}
demo1()

let demo2 = () => {
    console.log("demo2....................");
    let i = 0;
    while (i < count){
        console.log(i);
        i++;
    }
}
demo2()


let demo3 = () => {
    console.log("demo3....................");
    let i;
    for (i=0; i < count; i++){
        console.log(i);
    }

}
demo3()




/* 报错： 第二个i 变量 未定义 */

let demo4 = () => {
    console.log("demo4....................");

    for (let i=0; i < count; i++){
        console.log(i);
    }
    console.log(i);    //10
}
// demo4()

let demo5 = () => {
    console.log("demo5....................");
    let i = 0;
    for (; i < count; ){
        console.log(i);
        i++;
    }
}
demo5()








