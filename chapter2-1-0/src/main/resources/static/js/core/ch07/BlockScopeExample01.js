

function outputNumbers1(count){
    for (var i=0; i < count; i++){
        console.log(i);
    }
    console.log(i);   //count
}

outputNumbers1(5);




function outputNumbers2(count){
    for (let i=0; i < count; i++){
        console.log(i);
    }

    let i;    //variable re-declared
    console.log(i);   //count
}

outputNumbers2(5);




function outputNumbers3(count){
    (function () {
        for (let i=0; i < count; i++){
            console.log(i);
        }
    })();
    console.log(i);   //causes an error
}

outputNumbers3(5);