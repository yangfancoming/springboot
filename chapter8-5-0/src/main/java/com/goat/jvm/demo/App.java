package com.goat.jvm.demo;

/**
 运行本程序时，首先启动一个Java虚拟机进程，这个进程首先从classpath中找到 App.class文件，
 读取这个文件中的二进制数据，然后把 App 类的类信息存放到运行时数据区的方法区中，这就是 App 类的加载过程。
 接着，Java虚拟机定位到方法区中 App 类的Main()方法的字节码，开始执行它的指令。这个main()方法的第一条语句就是：
 Sample test1=new Sample("测试1");
 该语句的执行过程：
 1、 Java虚拟机到方法区找到Sample类的类型信息，没有找到，因为Sample类还没有加载到方法区（这里可以看出，java中的内部类是单独存在的，而且刚开始的时候不会跟随包含类一起被加载，等到要用的时候才被加载）。Java虚拟机立马加载Sample类，把Sample类的类型信息存放在方法区里。
 2、 Java虚拟机首先在堆区中为一个新的Sample实例分配内存, 并在Sample实例的内存中存放一个方法区中存放Sample类的类型信息的内存地址。
 3、 JVM的进程中，每个线程都会拥有一个方法调用栈，用来跟踪线程运行中一系列的方法调用过程，栈中的每一个元素就被称为栈帧，每当线程调用一个方法的时候就会向方法栈压入一个新帧。这里的帧用来存储方法的参数、局部变量和运算过程中的临时数据。
 4、位于“=”前的Test1是一个在main()方法中定义的一个变量（一个Sample对象的引用），因此，它被会添加到了执行main()方法的主线程的JAVA方法调用栈中。而“=”将把这个test1变量指向堆区中的Sample实例。
 5、JVM在堆区里继续创建另一个Sample实例，并在main方法的方法调用栈中添加一个Test2变量，该变量指向堆区中刚才创建的Sample新实例。
 6、JVM依次执行它们的printName()方法。当JAVA虚拟机执行test1.printName()方法时，JAVA虚拟机根据局部变量test1持有的引用，定位到堆区中的Sample实例，再根据Sample实例持有的引用，定位到方法去中Sample类的类型信息，从而获得printName()方法的字节码，接着执行printName()方法包含的指令，开始执行。
 */
public class App {

    public static void main(String[] args) {  //main 方法本身放入方法区。

        Sample test1 = new  Sample( " 测试1 " );   //test1是引用，所以放到栈区里， Sample是自定义对象应该放到堆里面
        Sample test2 = new  Sample( " 测试2 " );
        test1.printName();
        test2.printName();
    }
}

