# jacoco 使用

    enable toggle 'skip Tests ' model
    点击  lifecycle 下的 test 命令
    在指定目录下会生成 
            <!--指定生成.exec文件的存放位置-->
            <destFile>target/coverage-reports/jacoco-unit.exec</destFile>
            <!--Jacoco是根据.exec文件生成最终的报告，所以需指定.exec的存放路径-->
            <dataFile>target/coverage-reports/jacoco-unit.exec</dataFile>
            
     target/coverage-reports    下有二进制文件
     target/site/jacoco/index.html 就是代码覆盖率报告  可点击打开查看
     
     
     Tip：
     绿色部分：完全覆盖
     黄色部分：条件覆盖
     红色部分：未覆盖