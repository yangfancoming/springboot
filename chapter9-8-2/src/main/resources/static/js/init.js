$(document).ajaxStart(function() { Pace.restart(); });
$(function () {
    /*固定布局*/
    $("#fixCheckBox").click(function () {
        let neg = $('.main-header').outerHeight() ;
        let window_height = $(window).height();
        if($(this).is(':checked')) {
            $("body").addClass("fixed");
            $(".content-wrapper, .right-side").css('min-height', window_height);
        }else{
            $("body").removeClass("fixed");
            $(".content-wrapper, .right-side").css('min-height', window_height-neg);
            $(".control-sidebar").removeAttr("style");
        }
    })
    /*盒状布局*/
    $("#layoutBox").click(function(){
        if($(this).is(':checked')) {
            $("body").addClass("layout-boxed");
        }else{
            $("body").removeClass("layout-boxed");
        }
    })
});

$(function(){
    let clickHref="";//点击菜单判断使用
    //菜单列表html
    let menus = '';
    $.ajax({
        type: 'POST', url: "/menu" , data: {} ,
        success: (data)=> {
            GetData(0, data)
            $("#menu").append(menus);
            $(".sidebar-menu a").click(function () {  /*菜单点击事件*/
                let aHref=$(this).attr("href");
                if(clickHref==aHref){
                    if(aHref.substring(1,aHref.length)!=""){
                        Core.load("#content",aHref.substring(1,aHref.length));
                    }
                }else{
                    clickHref = aHref;//赋值
                }
            });
            loadMenuRefresh();/*初始化加载菜单样式*/
        }
    });
    //根据菜单主键id生成菜单列表html
    //id：菜单主键id
    //arry：菜单数组信息
    function GetData(id, arry) {
        let childArry = GetParentArry(id, arry);
        if (childArry.length > 0) {
            if(menus==""){
                menus += '<ul class="sidebar-menu">';
            }else{
                menus += '<ul class="treeview-menu">';
            }
            for (let i in childArry) {
                let childArryChild = GetParentArry(childArry[i].id, arry);
                if(childArryChild.length>0){
                    menus += '<li class="treeview"><a href="#"><i class="'+childArry[i].icon+'"></i> <span>'+childArry[i].name+'</span>'
                        +'<span class="pull-right-container">'
                        +'<i class="fa fa-angle-left pull-right"></i>'
                        +'</span></a>'
                }else{
                    menus += '<li><a href="#'+childArry[i].url.substring(1,childArry[i].url.length)+'"><i class="'+childArry[i].icon+'"></i><span>'+childArry[i].name+'</span></a>' ;
                }
                GetData(childArry[i].id, arry);
                menus += '</li>';
            }
            menus += '</ul>';
        }
    }

    //根据菜单主键id获取下级菜单
    //id：菜单主键id
    //arry：菜单数组信息
    function GetParentArry(id, arry) {
        let newArry = new Array();
        for (let i in arry) {
            if (arry[i].parentId == id)
                newArry.push(arry[i]);
        }
        return newArry;
    }
    /*刷新页面时加载菜单样式和菜单地址内容*/
    function loadMenuRefresh() {
        //初始化
        let localHref=document.location.href;
        let href2=localHref.split("#");
        if(href2.length==1||href2[1]==""||href2[1]=="workdest"){//首页工作台
            clickHref="#workdest";
            $('.sidebar-menu a[href="#workdest"]').parent().addClass("active");
            Core.load("#content","/workdest");
        }else{//非工作台链接
            clickHref="#"+href2[1];
            let menuActiveHref="#"+href2[1];
            $.each($(".sidebar-menu a"), function (i, item) {
                let itemHref = $(item).attr("href");
                if(itemHref==menuActiveHref){
                    $oneUl=$(this).parent().parent();
                    $twoUl=$(this).parent().parent().parent().parent();
                    $threeUl=$(this).parent().parent().parent().parent().parent().parent();
                    /*一级菜单*/
                    if($oneUl.hasClass("sidebar-menu")){
                        $(this).parent().addClass("active");
                    }else if($twoUl.hasClass("sidebar-menu")){
                        /*二级菜单*/
                        $(this).parent().addClass("active");
                        $oneUl.addClass("menu-open");
                        $oneUl.attr("style","display:block;");
                        $oneUl.parent().addClass("active");
                    }else if($threeUl.hasClass("sidebar-menu")){
                        $(this).parent().addClass("active");
                        $oneUl.addClass("menu-open");
                        $oneUl.show();
                        $oneUl.parent().addClass("active");
                        $twoUl.addClass("menu-open");
                        $twoUl.show();
                        $twoUl.parent().addClass("active");
                    }
                    return false;
                }
            })
            Core.load("#content",href2[1]);
        }
    }
})
/*锚点改变，加载内容*/
function loadContent() {
    let href=document.location.href;
    let href2=href.split("#");
    if(href2.length==1||href2[1]==""){
        window.location.href=href;
    }else{
        let menuActiveHref="#"+href2[1];
        $.each($(".sidebar-menu a"), function (i, item) {
            let itemHref = $(item).attr("href");
            if(itemHref==menuActiveHref){
                $oneUl=$(this).parent().parent();
                $twoUl=$(this).parent().parent().parent().parent();
                $threeUl=$(this).parent().parent().parent().parent().parent().parent();
                /*一级菜单*/
                if($oneUl.hasClass("sidebar-menu")){
                    $(".sidebar-menu li.active").removeClass("active");//删除菜单active
                    $(".sidebar-menu li.li-open").removeClass("li-open");
                    $(".sidebar-menu .menu-open").slideUp("fast");
                    $(".sidebar-menu .menu-open").removeClass("menu-open");
                    $(this).parent().addClass("active");
                }else if($twoUl.hasClass("sidebar-menu")){
                    /*二级菜单*/
                    $(".sidebar-menu li.active").removeClass("active");
                    $(this).parent().addClass("active");
                    if(!$oneUl.hasClass("menu-open")){
                        $(".sidebar-menu .menu-open").slideUp("fast");
                        $(".sidebar-menu .menu-open").removeClass("menu-open");
                        $(".sidebar-menu .li-open").removeClass("li-open")
                        $oneUl.slideDown("fast");
                        $oneUl.addClass("menu-open");
                        $oneUl.parent().removeClass("li-close");
                        $oneUl.parent().addClass("li-open");
                    }
                    $oneUl.parent().addClass("active");
                }else if($threeUl.hasClass("sidebar-menu")){
                    /*三级菜单*/
                    if(!$oneUl.hasClass("menu-open")){
                        if(!$twoUl.hasClass("menu-open")){
                            $(".sidebar-menu .menu-open").slideUp("fast");
                            $(".sidebar-menu .menu-open").removeClass("menu-open");
                            $(".sidebar-menu .li-open").removeClass("li-open")
                            $($oneUl).show();
                        }else{
                            $twoUl.find(".menu-open").slideUp();
                            $twoUl.find(".menu-open").removeClass("menu-open");
                            $(".sidebar-menu .li-open").removeClass("li-open");
                            $($oneUl).slideDown();
                        }
                    }
                    $(".sidebar-menu li.active").removeClass("active");//删除菜单active
                    $(this).parent().addClass("active");
                    $($oneUl).addClass("menu-open");
                    $($oneUl).parent().addClass("active");
                    $($oneUl).parent().removeClass("li-close");
                    $($twoUl).addClass("menu-open");
                    $($twoUl).slideDown("fast");
                    $($twoUl).parent().addClass("active");
                }
                return false;
            }
        })
        Core.load("#content",href2[1]);
    }
}