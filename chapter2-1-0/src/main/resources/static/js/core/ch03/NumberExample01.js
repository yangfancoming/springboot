
console.log(0.1 + 0.2);

let result = Number.MAX_VALUE + 1;
console.log(isFinite(result));    // false



console.log(NaN == NaN);       //false
console.log(isNaN(NaN));       //true
console.log(isNaN(10));        //false � 10 is a number
console.log(isNaN("10"));      //false � can be converted to number 10
console.log(isNaN("blue"));    //true � cannot be converted to a number
console.log(isNaN(true));      //false � can be converted to number 1



console.log(Number("Hello world!")); //NaN
console.log(Number("")); //0
console.log(Number("000011")); //11
console.log(Number(true));  //1




console.log(parseInt("1234blue"));  //1234
console.log(parseInt(""));  //NaN
console.log(parseInt("0xA")); //10 - hexadecimal
console.log(parseInt(22.5)); //22
console.log(parseInt("70"));  //70 - decimal
console.log(parseInt("0xf"));  //15 � hexadecimal



console.log(parseInt("AF", 16)); //175
console.log(parseInt("AF")); //NaN





console.log(parseInt("10", 2)); //2 � parsed as binary
console.log(parseInt("10", 8));  //8 � parsed as octal
console.log(parseInt("10", 10)); //10 � parsed as decimal
console.log(parseInt("10", 16)); //16 � parsed as hexadecimal




console.log(parseFloat("1234blue")); //1234 - integer
console.log( parseFloat("0xA")); //0
console.log(parseFloat("22.5"));  //22.5
console.log(parseFloat("22.34.5")); //22.34
console.log(parseFloat("0908.5")); //908.5
console.log(parseFloat("3.125e7")); //31250000
