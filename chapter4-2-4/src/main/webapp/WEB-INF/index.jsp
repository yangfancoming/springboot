
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>JPA + JSP + DataTable分页总结</title>
    <meta charset="utf-8">
    <script type="text/javascript" charset="utf8" src="dataTable/js/jquery-3.2.1.js"></script>
    <link rel="stylesheet" type="text/css" href="dataTable/css/jquery.dataTables.css">
    <link rel="stylesheet" type="text/css" href="dataTable/css/dataTables.bootstrap.css">
    <script type="text/javascript" charset="utf8" src="dataTable/js/jquery.dataTables.js"></script>
    <script type="text/javascript" charset="utf8" src="dataTable/js/dataTables.bootstrap.js"></script>
    <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<body>



<div  style="margin: 10px 10px 10px 10px">
    <table id="myTable" class="table table-striped table-bordered table-hover" cellspacing="0" width="100%">
        <thead>
        <tr>
            <th>编号</th>
            <th>姓名</th>
            <th>工作</th>
            <th>电话</th>
            <th>地址</th>
            <th>选项</th>
        </tr>
        </thead>
        <tbody>
        </tbody>
    </table>
</div>

</body>
</html>
<script type="text/javascript">
    $(document).ready( function () {

        $.ajaxPrefilter(function( options, original_Options, jqXHR ) {
            options.async = true;
        });

        function table() {
            $('#myTable').DataTable({
                language: {
//                    url: "dataTable/zh_CN.txt"
                },
                info: true,
                paging: true,
                bServerSide: true, //是否启动服务器端数据导入
                bSort:false,
                sAjaxSource: "/student/test",         //请求的地址
                fnServerData: retrieveData,           // 获取数据的处理函数
                autoWidth: false,  //禁用自动调整列宽
                stripeClasses: ["odd", "even"],  //为奇偶行加上样式，兼容不支持CSS伪类的场合
                processing: true,  //隐藏加载提示,自行处理
                serverSide: true,  //启用服务器端分页
                searching: false,  //禁用原生搜索
                orderMulti: false,  //启用多列排序
                order: [],  //取消默认排序查询,否则复选框一列会出现小箭头
                renderer: "bootstrap",  //渲染样式：Bootstrap和jquery-ui
                pagingType: "simple_numbers",  //分页样式：simple,simple_numbers,full,full_numbers
                columnDefs: [{
                    "targets": 'nosort',  //列的样式名
                    "orderable": false    //包含上样式名‘nosort’的禁止排序
                }],

                columns: [
                    {data: 'id'},
                    {data: 'userName'},
                    {data: 'password'},
                    {data: 'nickName'},
                    {data: 'email'},
                    {data: function (obj) {
                        op = "<div id='toolbar' class='btn-group'>";
                        op1 = "<button id='btn_edit' type='button' class='btn btn-default' onclick='show_detail(" + obj.id + ");'><span class='glyphicon glyphicon-list' aria-hidden='true'></span>详情</button>";
                        op2 = "<button id='btn_edit' type='button' class='btn btn-default' onclick='show_modify(" + obj.id + ");'><span class='glyphicon glyphicon-pencil' aria-hidden='true'></span>修改</button>";
                        op3 = "<button id='btn_edit' type='button' class='btn btn-default' onclick='show_delete(" + obj.id + ");'><span class='glyphicon glyphicon-remove' aria-hidden='true'></span>删除</button>";
                        op_ = "</div>";
                        return op + op1  + op2  + op3 +op_;
                    }
                    }
                ]
            });
        }

        function retrieveData(sSource, aoData, fnCallback) {
            $.ajax({
                url: sSource,                              //这个就是请求地址对应sAjaxSource
                data: {"aoData": JSON.stringify(aoData)},   //这个是把datatable的一些基本数据传给后台,比如起始位置,每页显示的行数 ,分页,排序,查询等的值
                type: 'GET',dataType: 'json', async: false,
                success: function (result) {
                    console.log(result,111111111111);// doit
                    fnCallback(result);                     //把返回的数据传给这个方法就可以了,datatable 会自动绑定数据的
                },
                error: function (msg) {
                    alert("初始化信息失败" + msg);
                }
            });
        }

        table();

    });
</script>