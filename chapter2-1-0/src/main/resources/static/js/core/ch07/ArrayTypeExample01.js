


let colors = new Array(3);      //create an array with three items
let names = new Array("Greg");  //create an array with one item, the string "Greg"
console.log(colors.length); // 3
console.log(names.length); // 1



let colors1 = ["red", "blue", "green"]; //creates an array with three strings
let names1 = [];                        //creates an empty array
let values1 = [1,2,];                   //AVOID! Creates an array with 2 or 3 items
let options1 = [,,,,,];                 //AVOID! creates an array with 5 or 6 items

console.log(colors1.length);    //3
console.log(names1.length);     //0
console.log(values1.length);    //2 (FF, Safari, Opera) or 3 (IE)
console.log(options1.length);   //5 (FF, Safari, Opera) or 6 (IE)
colors.length = 2;
console.log(colors[2]);        //undefined

colors.length = 4;
console.log(colors[3]);        //undefined





let colors2 = new Array(3);      //create an array with three items
colors2[colors2.length] = "black";          //add a color
colors2[colors2.length] = "brown";          //add another color

console.log(colors2.length);    //5
console.log(colors2[3]);        //black
console.log(colors2[4]);        //brown

console.log("-------------------------------------------------");


let colors3 = ["red", "blue", "green"];    //creates an array with three strings
colors3[99] = "black";                     //add a color (position 99)
console.log(colors3.length);  //100


console.log("-------------------------------------------------");

let colors4 = ["red", "blue", "green"];    //creates an array with three strings
console.log(colors4.toString());    //red,blue,green
console.log(colors4.valueOf());     //red,blue,green
console.log(colors4);               //red,blue,green