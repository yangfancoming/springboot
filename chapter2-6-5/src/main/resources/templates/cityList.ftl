<!DOCTYPE html>

<html lang="en">

<body>
<#-- list  指令-->

<p>We have these animals:
<table border=1>
<#list cityList as city>
<tr><td>${city.cityName}<td>${city.description}
</#list>
</table>
</body>

</html>