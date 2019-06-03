

let i = 24;

if (i > 25)
    console.log("Greater than 25.");    //one-line statement
else {
    console.log("Less than or equal to 25.");  //block statement
}

console.log("-----------------------------------");    //one-line statement

if (i > 25) {
    console.log("Greater than 25.")
} else if (i < 0) {
    console.log("Less than 0.");
} else {
    console.log("Between 0 and 25, inclusive.");
}