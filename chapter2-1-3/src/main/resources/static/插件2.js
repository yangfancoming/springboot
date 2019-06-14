

$.fn.myPlugin = function() {
    //在这里面,this指的是用jQuery选中的元素 eg :$('a'),则this=$('a')
    this.css('color', 'red');

    /**
     我们已经知道this指代jQuery选择器返回的集合，那么通过调用jQuery的.each()方法就可以处理合集中的每个元素了，
     但此刻要注意的是，在each方法内部，this指带的是普通的DOM元素了，如果需要调用jQuery的方法那就需要用$来重新包装一下。
    */
    this.each(function() {
        //对每个元素进行操作
        let href = $(this).attr('href');
        console.log(href)
        $(this).append(href);
    })
}


/**
 jQuery.extend() 函数用于将一个或多个对象的内容合并到目标对象。
 注意： 1. 如果只为$.extend()指定了一个参数，则意味着参数target被省略。此时，target就是jQuery对象本身。通过这种方式，我们可以为全局对象jQuery添加新的函数。
        2. 如果多个对象具有相同的属性，则后者会覆盖前者的属性值。
*/

$.fn.myPlugin2 = function(options) {
    let defaults = {
        'color': 'red',
        'fontSize': '12px'
    };
    // let settings = $.extend(defaults, options);
    let settings = $.extend({},defaults, options);
    return this.css({
        'color': settings.color,
        'fontSize': settings.fontSize
    });

    /**
     注意到上面代码调用extend时会将defaults的值改变，这样不好，
     因为它作为插件因有的一些东西应该维持原样，另外就是如果你在后续代码中还要使用这些默认值的话，
     当你再次访问它时它已经被用户传进来的参数更改了。
     一个好的做法是将一个新的空对象做为$.extend的第一个参数，defaults和用户传递的参数对象紧随其后，
     这样做的好处是所有值被合并到这个空对象上，保护了插件里面的默认值。
    */
}

