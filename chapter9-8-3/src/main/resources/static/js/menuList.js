layui.use(['form','layer','table','laytpl'],function(){
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        table = layui.table;

    //菜单列表
    var tableIns = table.render({
        elem: '#menuList',
        url : '/menu/list',
        cellMinWidth : 95,
        page : true,
        height : "full-125",
        limits : [10,15,20,25],
        limit : 20,
        cols : [[
            {type: "checkbox", fixed:"left", width:50},
            {field: 'menuId', title: '编号', minWidth:100, align:"center"},
            {field: 'parentId', title: '上级编号', minWidth:100, align:"center"},
            {field: 'menuName', title: '菜单名称', minWidth:100, align:"center"},
            {field: 'url', title: '菜单地址', minWidth:80, align:'center' },
            {field: 'perms', title: '权限', align:'center'},
            {field: 'icon', title: '图标',minWidth:100, align:'center'},
            {field: 'type', title: '类型', align:'center'},
            {field: 'orderNum', title: '排序', align:'center'},
            {field: 'createTime', title: '创建时间', align:'center',minWidth:180,templet: "<div>{{layui.util.toDateString(d.ordertime, 'yyyy-MM-dd HH:mm:ss')}}</div>"},
            {field: 'modifyTime', title: '更改时间', align:'center',minWidth:180,templet: "<div>{{layui.util.toDateString(d.ordertime, 'yyyy-MM-dd HH:mm:ss')}}</div>"},
            {title: '操作', minWidth:175, templet:'#userListBar',fixed:"right",align:"center"}
        ]],

        done: function(res, curr, count){
            console.log(res);
            console.log(curr); //得到当前页码
            console.log(count);  //得到数据总量
        }
    });

    //搜索【此功能需要后台配合，所以暂时没有动态效果演示】
    $(".search_btn").on("click",function(){
        if($(".searchVal").val() != ''){
            table.reload("newsListTable",{
                page: {
                    curr: 1 //重新从第 1 页开始
                },
                where: {
                    key: $(".searchVal").val()  //搜索的关键字
                }
            })
        }else{
            layer.msg("请输入搜索的内容");
        }
    });

    //添加 菜单
    function addMenu(edit){
        var index = layui.layer.open({
            title : "新增菜单", type : 2, content : "/menu/menuAdd",
            area: ['600px', '500px'], //指定 弹出框 大小
            success : function(layero, index){
                var body = layui.layer.getChildFrame('body', index);
                if(edit){ // 如果是 编辑操作 则会把当条数据传过来
                    body.find(".username").val(edit.username);  //登录名
                    body.find(".email").val(edit.email);  //邮箱
                    body.find(".ssex input[value="+edit.ssex+"]").prop("checked","checked");  //性别
                    body.find(".deptId").val(edit.deptId);  //会员等级
                    body.find(".status").val(edit.status);    //用户状态
                    // body.find(".userDesc").text(edit.userDesc);    //用户简介
                    form.render();
                }
                setTimeout(function(){
                    layui.layer.tips('点击此处返回用户列表', '.layui-layer-setwin .layui-layer-close', {  tips: 3 });
                },500)
            }
        })
        window.sessionStorage.setItem("index",index);
        //改变窗口大小时，重置弹窗的宽高，防止超出可视区域（如F12调出debug的操作）
        $(window).on("resize",function(){
            layui.layer.full(window.sessionStorage.getItem("index"));
        })
    }
    // 新增菜单 按钮
    $(".addMenu_btn").click(function(){
        addMenu();
    })

    //批量删除
    $(".delAll_btn").click(function(){
        var checkStatus = table.checkStatus('userListTable'),
            data = checkStatus.data,
            newsId = [];
        if(data.length > 0) {
            for (var i in data) {
                newsId.push(data[i].newsId);
            }
            layer.confirm('确定删除选中的用户？', {icon: 3, title: '提示信息'}, function (index) {
                tableIns.reload();
                layer.close(index);
            })
        }else{
            layer.msg("请选择需要删除的用户");
        }
    })

    //列表操作
    table.on('tool(menuList)', function(obj){
        var layEvent = obj.event,
            data = obj.data;

        if(layEvent === 'edit'){ //编辑
            addMenu(data);
        }else if(layEvent === 'usable'){ //启用禁用
            var _this = $(this),
                usableText = "是否确定禁用此用户？",
                btnText = "已禁用";
            if(_this.text()=="已禁用"){
                usableText = "是否确定启用此用户？",
                btnText = "已启用";
            }
            layer.confirm(usableText,{
                icon: 3,
                title:'系统提示',
                cancel : function(index){
                    layer.close(index);
                }
            },function(index){
                _this.text(btnText);
                layer.close(index);
            },function(index){
                layer.close(index);
            });
        }else if(layEvent === 'del'){ //删除
            layer.confirm('确定删除此用户？',{icon:3, title:'提示信息'},function(index){
                // $.get("删除文章接口",{
                //     newsId : data.newsId  //将需要删除的newsId作为参数传入
                // },function(data){
                    tableIns.reload();
                    layer.close(index);
                // })
            });
        }
    });

})
