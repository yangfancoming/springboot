

let age = 29;
let anotherAge = --age + 2;

console.log(age);         //outputs 28
console.log(anotherAge);  //outputs 30


let demo1 = () => {
    let num1 = 2;
    let num2 = 20;
    let num3 = --num1 + num2;    //equals 21
    let num4 = num1 + num2;      //equals 21
    console.log(num3);
    console.log(num4);
}
demo1()

let demo2 = () => {
    let num1 = 2;
    let num2 = 20;
    let num3 = num1-- + num2;    //equals 22
    let num4 = num1 + num2;      //equals 21
    console.log(num3);
    console.log(num4);
}
demo2()


let s1 = "2";
let s2 = "z";
let b = false;
let f = 1.1;
let o = {
    valueOf: function() {
        return -1;
    }
};

s1++;   //value becomes numeric 3
s2++;   //value becomes NaN
b++;    //value becomes numeric 1
f--;    //value becomes 0.10000000000000009
o--;    //value becomes numeric �2  

console.log(s1);
console.log(s2);
console.log(b);
console.log(f);
console.log(o);