package com.goat.B.B03.item08;


import org.junit.Test;
import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;


/**
 * JDK动态代理
 *
 *  JDK动态代理所用到的代理类在程序调用到代理类对象时才由JVM真正创建，
 *  JVM根据传进来的 业务实现类对象以及方法名 ，动态地创建了一个代理类的class文件并被字节码引擎执行，
 *  然后通过该代理类对象进行方法调用。我们需要做的，只需指定代理类的预处理、调用后操作即可。
*/
public class App {

    /**
     在使用时，首先创建一个业务实现类对象和一个代理类对象，
     然后定义接口引用（这里使用向上转型）并用代理对象.bind(业务实现类对象)的返回值进行赋值。
     最后通过接口引用调用业务方法即可。（接口引用真正指向的是一个绑定了业务类的代理类对象，所以通过接口方法名调用的是被代理的方法们）
    */
    @Test
    public void testJDK() {
        BookFacadeImpl bookFacadeImpl = new BookFacadeImpl(); // 业务实现类对象 (被代理)
        BookFacadeProxy proxy = new BookFacadeProxy(); // 代理类对象
        BookFacade bookfacade = (BookFacade) proxy.bind(bookFacadeImpl);
        bookfacade.addBook();
    }

    /**
     *  原理：
     *  1. 拿到被代理对象的引用，然后获取它的接口
     *  2. JDK代理重新生成一个类，同时实现我们给的代理对象所实现的接口
     *  3. 把代理对象的引用也拿到了
     *  4. 重新动态生成一个class字节码
     *  5. 重新编译
    */
    @Test
    public void testJDK2() throws Exception {
        byte[] goats = ProxyGenerator.generateProxyClass("goat", new Class[]{BookFacade.class});
        FileOutputStream fileOutputStream = new FileOutputStream("E:\\Code\\J2EE_code\\MySpringBoot\\springboot\\chapter9-5-1\\src\\main\\java\\com\\goat\\B\\B03\\item08\\tom.class");
        fileOutputStream.write(goats);
        fileOutputStream.close();
    }

}
