
/**
验证：逻辑与 中  只要第一个条件不成立 就不会再往下判断了
*/

let demo1 = () => {
    let found = true;
    let result = (found && someUndeclaredVariable);    //error occurs here
    console.log(result);    //this line never executes

}
demo1()

let demo2 = () => {
    let found = false;
    let result = (found && someUndeclaredVariable);    //no error
    console.log(result);    //works
}
demo2()



