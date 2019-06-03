

console.log(!false);      //true
console.log(!"blue");     //false
console.log(!0);          //true
console.log(!NaN);        //true
console.log(!"");         //true
console.log(!12345);      //false



console.log(!!"blue");     //true
console.log(!!0);          //false
console.log(!!NaN);        //false
console.log(!!"");         //false
console.log(!!12345);      //true