

let num = 0;

for (let i=1; i < 10; i++) {
    if (i % 5 == 0) {
        break;
    }
    num++;
}

console.log(num);    //4



let num1 = 0;

outermost:
    for (let i=0; i < 10; i++) {
        for (let j=0; j < 10; j++) {
            if (i == 5 && j == 5) {
                break outermost;
            }
            num1++;
        }
    }

console.log(num1);    //55