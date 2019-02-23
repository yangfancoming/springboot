# 应用场景
    应用场景
    规则引擎虽然非常强大，但并非所有场景都适用。一般来说，规则引擎适用的项目都具有以下一个或多个特征：
    存在一个非常复杂的场景，即使对于商业专家也难以完全定义
    没有已知或定义明确的算法解决方案
    有不稳定需求，需要经常更新
    需要快速做出决策，通常是基于部分数据量

# 1、添加maven依赖包
        <dependency>
          <groupId>org.drools</groupId>
          <artifactId>drools-core</artifactId>
          <version>7.7.0.Final</version>
        </dependency>
        <dependency>
          <groupId>org.drools</groupId>
          <artifactId>drools-compiler</artifactId>
          <version>7.7.0.Final</version>
        </dependency>
        <dependency>
          <groupId>org.drools</groupId>
          <artifactId>drools-templates</artifactId>
          <version>7.7.0.Final</version>
        </dependency>
# 2、创建一个xml，注意一定要放在 resources/META-INF 文件夹下，drools 会自动解析它
    <?xml version="1.0" encoding="UTF-8"?>
    <kmodule xmlns="http://www.drools.org/xsd/kmodule">
    <kbase name="rules">
    	<ksession name="all-rules"/>
    </kbase>
    </kmodule>


#  语法规则
    package 包名
    rule "规则名"
    when
        (条件) - 也叫作规则的 LHS(Left Hand Side)
    then
        (动作/结果) - 也叫作规则的 RHS(Right Hand Side)
    end
    
    每个 drl 都必须声明一个包名，这个包名与 Java 里面的不同，
    它不需要与文件夹的层次结构一致。规则名是规则的唯一标识，
    所以规则编写过程中需要保证它是不重复的。
    规则的条件(LHS)是按照 DRL 语言编写的，条件eval(true)表示永远为真，
    即该条规则总会获得执行。而规则的结果(RHS)使用 Java 语言实现，
    简单地输出了 HelloWorld 字样。
    
    
# Drools Jar 包介绍：
    
    knowledge-api.jar - 提供接口和工厂。它清楚地描述用户 API 的职责，还有什么引擎 API。
    knowledge-internal-api.jar - 提供内部接口和工厂。
    drools-core.jar - 核心引擎，运行时组件。包含 RETE 引擎和 LEAPS 引擎。
    drools-compiler.jar - 包含编译器/构建器组件，以获取规则源，并构建可执行规则库。
    drools-decisiontables.jar - 决策表编译器组件，在 drools-compiler 组件中使用。支持 Excel 和 CSV 输入格式。

