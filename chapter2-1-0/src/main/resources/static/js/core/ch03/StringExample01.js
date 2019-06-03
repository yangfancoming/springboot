

let age = 11;
let ageAsString = age.toString();    //the string "11"
let found = true;
let foundAsString = found.toString(); //the string "true"

console.log(ageAsString); // 11
console.log(typeof ageAsString); // string
console.log(foundAsString); // true
console.log(typeof foundAsString); // string



let num = 10;
console.log(num.toString());       //"10"
console.log(num.toString(2));      //"1010"
console.log(num.toString(8));      //"12"
console.log(num.toString(10));     //"10"
console.log(num.toString(16));     //"a"



let value1 = 10;
let value2 = true;
let value3 = null;
let value4;

console.log(String(value1));     //"10"
console.log(String(value2));     //"true"
console.log(String(value3));     //"null"
console.log(String(value4));     //"undefined"