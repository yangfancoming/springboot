

let i = 25;

switch (i) {
    case 25:console.log("25");break;
    case 35:console.log("35");break;
    case 45:console.log("45");break;
    default:
        console.log("Other");
}

switch (i) {
    case 25:  /* falls through */
    case 35:console.log("35");break;
    case 45:console.log("45");break;
    default:
        console.log("Other");
}


switch ("hello world") {
    case "hello" + " world":
        console.log("Greeting was found.");
        break;
    case "goodbye":
        console.log("Closing was found.");
        break;
    default:
        console.log("Unexpected message was found.");
}


let num = 25;
switch (true) {
    case num < 0: console.log("Less than 0."); break;
    case num >= 0 && num <= 10:console.log("Between 0 and 10.");break;
    case num > 10 && num <= 20:console.log("Between 10 and 20."); break;
    default:
        console.log("More than 20.");
}