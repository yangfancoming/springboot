<!DOCTYPE html>

<html lang="en">
<#--
数据模型可以被看成是树形结构。
标量用于存储单一的值。这种类型的值可以是字符串，数字，日期/时间或者是布尔值。
哈希表是一种存储变量及其相关且有唯一标识名称的容器。
序列是存储有序变量的容器。存储的变量可以通过数字索引来检索，索引通常从0开始。
-->
<body>
</body>


<h1>
    Welcome ${user} !     <br/>

<#--if 指令-->
    Welcome ${user} <#if user == "Big Joe">, our beloved leader</#if>!     <br/>
    Welcome ${user} <#if user == "goat">, our beloved leader</#if>!     <br/>


    <#if num == 0>  0000 </#if>
    <#if num != 0>  1111 </#if>

<#--if else  指令-->
    <#if num == 0>
        0000
    <#else>
        11111
    </#if>
    <#--如果变量本身就是布尔值(true/false)，则可以直接让其作为 if 的 condition-->
    <#if mark >
        true
    <#else>
        false
    </#if>
</h1>




</html>