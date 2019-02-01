
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>ECharts</title>
    <meta charset="utf-8">
    <script type="text/javascript" src="../js/jquery-1.7.js"></script>
    <script type="text/javascript" src="../js/echarts.js"></script>  <!-- 引入 ECharts 文件 -->
</head>
${msg}

<body>
    <!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->
    <div id="main" style="width: 600px;height:400px;"></div> <br>
    <div id="main1" style="width: 600px;height:400px;"></div> <br>

</body>
</html>

<script>
//  然后就可以通过 echarts.init 方法初始化一个 echarts 实例并通过 setOption 方法生成一个简单的柱状图，
//  基于准备好的dom  初始化echarts实例
var myChart = echarts.init(document.getElementById('main'));

// 指定图表的配置项和数据
var option = {
    title: {
        text: 'ECharts 入门示例'
    },
    tooltip: {},
    legend: {
        data:['销量']
    },
    xAxis: {
        data: ["衬衫","羊毛衫","雪纺衫","裤子","高跟鞋","袜子"]
    },
    yAxis: {},
    series: [{
        name: '销量',
        type: 'bar',
        data: [5, 20, 36, 10, 10, 20]
    }]
};
// 使用刚指定的配置项和数据显示图表。
myChart.setOption(option);



var myChart1 = echarts.init(document.getElementById('main1'));

// 指定图表的配置项和数据
myChart1.setOption({
    title: {
        text: 'ECharts 入门示例'
    },
    tooltip: {},
    legend: {
        data:['销量']
    },
    xAxis: {
        data: []
    },
    yAxis: {},
    series: [{
        name: '销量',
        type: 'bar',
        data: []
    }]
});

myChart1.showLoading();


var names=[];    //类别数组（实际用来盛放X轴坐标值）
var nums=[];    //销量数组（实际用来盛放Y坐标值）

$.ajax({
    type : "get",
    async : false,            //异步请求（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
    url : "list",    //请求发送到TestServlet处
    data : {},
    dataType : "json",        //返回数据形式为json
    success : function(result) {
        //请求成功时执行该函数内容，result即为服务器返回的json对象
        var data = result.data;
        if (data) {
            for(var i=0;i<data.length;i++){
                names.push(data[i].name);    //挨个取出类别并填入类别数组
            }
            for(var i=0;i<data.length;i++){
                nums.push(data[i].num);    //挨个取出销量并填入销量数组
            }
            myChart1.hideLoading();    //隐藏加载动画
            myChart1.setOption({        //加载数据图表
                xAxis: {
                    data: names
                },
                series: [{
                    // 根据名字对应到相应的系列
                    name: '销量',
                    data: nums
                }]
            });

        }

    },
    error : function() {
        //请求失败时执行该函数
        alert("图表请求数据失败!");
        myChart1.hideLoading();
    }
})
</script>