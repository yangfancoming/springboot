<!DOCTYPE html>

<html lang="en">

<body>
<#-- list  指令-->

<p>We have these animals:
<table border=1>
    <tr>
        <th>序号</th>
        <th>城市名称</th>
        <th>描述</th>
    </tr>

    <#list cityList as city>
        <#if city_index%2 == 0>
            <tr bgcolor="red">  <#--如果是偶数行 显示红色-->
        <#else>
            <tr bgcolor="#adff2f"> <#-- 否则 显示绿色-->
        </#if>
            <td> ${city_index+1} </td> <#--取下标-->
            <td> ${city.cityName} </td>
            <td> ${city.description} </td>
        </tr>
    </#list>
</table>
</body>

</html>