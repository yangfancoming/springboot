
/**
 splice()，数组中添加/删除元素。例如：arrayObject.splice(index,howmany,item1,.....,itemX)。
 index是必选的，规定添加/删除项目的位置。
 howmany必须项，表示删除项目的个数，如果为0表示不删除元素。
 splice()可删除从index开始的howmany个元素，并可以用item元素替代删除的元素。i
 tem可选参数，表示新添加的项。
*/
let arr1 = new Array(5);
arr1[0] = "amy";
arr1[1] = "elice";
arr1[2] = "divi";
arr1[3] = "lvy";
arr1[4] = "marry";
arr1.splice(1, 0, "willian");
console.log(arr1); //输出：amy，willian,elice,divi,lvy，在数组第一个位置增加一个元素，其值是"willian"

let arr = new Array(5);
arr[0] = "amy";
arr[1] = "elice";
arr[2] = "divi";
arr[3] = "lvy";
arr[4] = "marry";
arr.splice(1, 2, "willian");
console.log(arr);
//输出：amy，willian,lvy，从数组第一个位置起删除两个元素，并用新的元素“willian”代替删除的元素。












