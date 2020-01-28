<#-- assign 命令： 再ftl模板中定义数据存入到root节点下 -->
<#assign goat="melody">
<#assign test="Foo">



欢迎您：${username}
测试 assign：${goat}

测试 内置函数
lower_case ：${test?lower_case}

<#include "template02.ftl">