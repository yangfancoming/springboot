


console.log(null == undefined);    //true
console.log(null === undefined);   //false

console.log("NaN" == NaN);        //false
console.log("NaN" === NaN);       //false
console.log(NaN == NaN);          //false
console.log(NaN === NaN);         //false
console.log(NaN != NaN);          //true
console.log(NaN !== NaN);         //true

console.log(false == 0);          //true
console.log(false === 0);         //false
console.log(true == 1);           //true
console.log(true === 1);          //false

console.log(null == 0);           //false
console.log(undefined == 0);      //false

console.log(5 == "5");            //true
console.log(5 === "5");           //false 


console.log('demo2.................');
let result1 = ("55" == 55);    //true � equal because of conversion
let result2 = ("55" === 55);   //false � not equal because different data types
console.log(result1);
console.log(result2);

console.log('demo3.................');
let result11 = ("55" != 55);    //false � equal because of conversion
let result22 = ("55" !== 55);   //true � not equal because different data types
console.log(result11);
console.log(result22);