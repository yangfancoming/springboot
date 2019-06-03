
let name = "The Window";

let object = {
    name : "My Object",
    getNameFunc : function(){
        return function(){
            return this.name;
        };
    }
};
console.log(object.getNameFunc()());  //"The Window"



let demo2 = () => {
    let name = "The Window";

    let object = {
        name : "My Object",

        getNameFunc : function(){
            let that = this;
            return function(){
                return that.name;
            };
        }
    };

    console.log(object.getNameFunc()());  //"MyObject"
}
demo2()



let demo3 = () => {
    let name = "The Window";

    let object = {
        name : "My Object",

        getName: function(){
            return this.name;
        }
    };

    console.log(object.getName());     //"My Object"
    console.log((object.getName)());   //"My Object"
    console.log((object.getName = object.getName)());   //"The Window" in non-strict mode
}
demo3()








