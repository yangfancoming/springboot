

function calculateByte(str){
    let len = str.length;
    let bytes = len;
    for(let i=0; i<len; i++){
        if (str.charCodeAt(i) > 255) bytes++;
    }
    return bytes;
}

console.log(calculateByte("我的"))