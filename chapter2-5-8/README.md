# protocol buf  使用流程
    1. 编写 proto 接口文件
    2. 使用proto.exe 根据接口文件生成实体类
        protoc -I=$SRC_DIR --java_out=$DST_DIR $SRC_DIR/addressbook.proto
        
        切换到 proto.exe 所在目录
        E:\Code\J2EE_code\MySpringBoot\springboot\chapter2-5-8\src\main\java\com\goat\chapter258\msg>protoc --java_out=./  ./Person.proto
        执行命令 protoc --java_out=./  ./Person.proto
        意思是：根据当前目录下的 Person.proto 接口文件，在当前目录下生成java实体类，

    3. 不要尝试去修改/继承 生成出来的类文件。。。。