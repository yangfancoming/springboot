
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <div id="main" style="width: 600px;height:400px;"></div>

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
</script>