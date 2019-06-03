

function Person(name){
    this.getName = ()=>{ return name; };
    this.setName = (value)=> {name = value; };
}

let person = new Person("Nicholas");
console.log(person.getName());   //"Nicholas"
person.setName("Greg");
console.log(person.getName());   //"Greg"




(function(){
    let name = "";
    Person = (value)=>{  name = value; };
    Person.prototype.getName =  ()=>{  return name; };
    Person.prototype.setName =  (value)=>{  name = value; };

})();

let person1 = new Person("Nicholas");
console.log(person1.getName());   //"Nicholas"
person1.setName("Greg");
console.log(person1.getName());   //"Greg"

let person2 = new Person("Michael");
console.log(person1.getName());   //"Michael"
console.log(person2.getName());   //"Michael"