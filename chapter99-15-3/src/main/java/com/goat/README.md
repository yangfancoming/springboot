# 流的分类
    按操作数据单位不同： 字节流 8bit 、 字符流 16bit
    流向不同： 输入流、输出流   （针对内存）
    
                字节流     字符流
    输入流：InputStream     Reader
    输出流：OutputStream    Writer
    
    
# 报错： java.io.FileNotFoundException:  E:\Code\J2EE_code\MySpringBoot\springboot\chapter99-15-3\src\main\resources\copy01.txt (文件名、目录名或卷标语法不正确。)

    解决方法： 文件路径字符串中 去掉头尾空格。。。。
             String path1 = " E:\\Code\\J2EE_code\\MySpringBoot\\springboot\\chapter99-15-3\\src\\main\\resources\\copy01.txt";
    改成：   String path1 = "E:\\Code\\J2EE_code\\MySpringBoot\\springboot\\chapter99-15-3\\src\\main\\resources\\copy01.txt";