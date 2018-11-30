<!DOCTYPE html>

<html lang="en">

<body>
<h3>对象的取值</h3>
    城市名称是： ${city.cityName}! <br>
    城市描述是：${city.description}! <br>

<h3>日期的处理</h3>
    <#--Tip: If you need a particular format only once, use ?string(pattern), like ?string('dd.MM.yyyy HH:mm:ss'), to specify which fields to display.-->
    <#--Tip: Use ?date, ?time, or ?datetime to tell FreeMarker the exact type.-->
    日期类型date处理：${date?date}<br>  <#--2018-11-30-->
    日期类型time处理：${date?time}<br>  <#--20:59:46-->
    日期类型datetime处理：${date?datetime}<br> <#--2018-11-30 20:59:46-->
    日期类型 自定义格式 处理：${date?string('dd.MM.yyyy HH:mm:ss')}<br> <#--30.11.2018 21:06:04-->

<h3>null的处理</h3>
    <#--freemarker 早些版本遇到null是直接报错的 但是目前使用的这个版本没有报错-->
    我是null： ${val!"如果你是空 我就是默认值！"} </br>

    <h4>使用if判断null 值 </h4>
    <#if val??>
        val 是有值的 </br>
    <#else >
        val 的值是null </br>
    </#if>



<h3>include 标签测试</h3>

<#include "foot.ftl">


</body>

</html>