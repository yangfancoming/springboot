
/**
 当不传入参数的时候默认使用形参里的默认值
 function Point(x = 1,y = 2) {
      this.x = x;
      this.y = y;
    }
 */

function test1(x = 1,y = 1) {
    console.log(x,y)
}

let test2 =(x = 0,y = 0)=> console.log(x,y);


test1(3,4)

test2() // 使用形参默认值

