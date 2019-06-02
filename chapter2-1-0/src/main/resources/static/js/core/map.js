

let json={name:"fan",age:18}
let m = new Map()
m.set(json,'me')
m.set('name','fan')
console.log(m.get('name'));//fan
console.log(m.get(json));//me,根据对象搜索