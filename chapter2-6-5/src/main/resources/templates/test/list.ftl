<!DOCTYPE html>

<html lang="en">

<body>
</body>


<h1>
    student 信息  <br/>
    student.name = ${student.name}    <br/>
    student.age = ${student.age}    <br/>
    student.pet.age = ${student.pet.age}    <br/>
    student.pet.nickName = ${student.pet.nickName}    <br/>
<#--    student.location = ${student.location}    <br/>-->


    student.skill  信息  <br/>
    <#list student.skill as gaga>
        <tr>
            <td> ${gaga} </td>  <br/>
        </tr>
    </#list>

</h1>
<br/>

list 示例二 <br/>

<#list ["星期一","星期二","星期三","星期四","星期五"] as x>
<#-- as后的别名+ _index 为每一项的索引 -->
    ${x_index + 1}.${x} <br/>
</#list>

list 示例三 <br/>
<#list ["星期一","星期二","星期三","星期四","星期五"] as xx>
<#-- as后的别名+ _has_next 为 循环中是否还有下一项 -->
    <#if xx_has_next> ***  </#if>
    ${xx_index + 1}.${x} <br/>
</#list>

list 示例四 <br/>
<#list ["星期一","星期二","星期三","星期四","星期五"] as x>
    <#if x_has_next> ***  </#if>
    ${x_index + 1}.${x} <br/>
    <#if x="星期四">
        <#break > <#--如果遇到 星期四 则跳出循环-->
    </#if>
</#list>

</html>