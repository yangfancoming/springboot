/**
 * Created by JerryChen on 2016/12/30.
 */
var arrayUtils = {};
(function (object) {
    //arguments parameter
    object.concat = function (arr) {
        if (arguments.length > 0) {
            for (i = 1;i < arguments.length; i++) {
                arr=arr.concat(arguments[i]);
            }
        }
        return arr;
    };
    object.join = function (arr,separator) {
        return arr.join(separator);
    };
    object.push = function (arr) {
        if (arguments.length > 0) {
            for (i = 1;i < arguments.length; i++) {
                arr.push(arguments[i]);
            }
        }
        return arr;
    };
    object.slice = function (arr,start,end) {
        return arr.slice(start,end);
    };
    object.sort = function (arr,isDesc) {
         if(isDesc){
             arr.sort(function (a,b) {
                 return a<b?1:-1;
             });
         }else{
             arr.sort(function (a,b) {
                 return a<b?-1:1;
             });
         }
         return arr;
    };
    object.unshift = function (arr) {
        if (arguments.length > 0) {
            for (i = 1;i < arguments.length; i++) {
                arr.unshift(arguments[i]);
            }
        }
        return arr;
    };
    object.inArray=function (arr,targetValue) {
        var hasTargetValue=false;
        $.each(arr,function (index,item) {
            if(item==targetValue){
                hasTargetValue=true;
            }
        });
        return hasTargetValue;
    };
    //差集
    object.except=function (sourceArray,targetArray) {
        var self=this;
        var exceptArray=[];
        $.each(sourceArray,function (index,item) {
            if(!self.inArray(targetArray,item)){
                exceptArray.push(item);
            }
        });
        $.each(targetArray,function (index,item) {
            if(!self.inArray(sourceArray,item)){
                exceptArray.push(item);
            }
        });
        return exceptArray;
    };
    //交集
    object.intersect=function (sourceArray,targetArray) {
        var self=this;
        var intersectArray=[];
        $.each(sourceArray,function (index,item) {
            if(self.inArray(targetArray,item)){
                intersectArray.push(item);
            }
        });
        return intersectArray;
    };
})(arrayUtils);
