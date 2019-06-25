package com.goat.controller;


import com.goat.bean2.Dog;
import com.goat.service.HelloService;
import com.goat.service.TestService;
import com.goat.service.TestService2;
import com.goat.utils.SpringContextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.hamcrest.core.IsSame.sameInstance;
import static org.junit.Assert.assertThat;


@RestController
@RequestMapping("/testbean")
public class TestBean {

    @Autowired private ApplicationContext ac;
    @Autowired private TestService testService;
    @Autowired private TestService2 testService2;
    @Autowired private HelloService helloService;

    //    http://localhost:1111/testbean/test0
    @GetMapping("/test0")
    public void test0() {
        String[] str= ac.getBeanDefinitionNames();
        for (String string : str) {
            System.out.println("***---***"+string);
        }
    }

    //    http://localhost:1111/testbean/test1
    @GetMapping("/test1")
    public void test1() {
        String[] beanNamesForType = ac.getBeanNamesForType(Dog.class); // 根据 bean 的类型 从 IOC容器中获取 bean 的实例  数组
        System.out.println(beanNamesForType);
    }

    //    http://localhost:1111/testbean/testDog1
    @GetMapping("/testDog1")
    public void testDog1() {
//      Dog beanNamesForType = ac.getBean(Dog.class);  // 根据 bean 的类型 从 IOC容器中获取 bean 的实例  单个
        Dog dog03 = ac.getBean("dog03",Dog.class); // 根据 bean 的类型 和 bean id  从 IOC容器中获取 bean 的实例  单个
        System.out.println(dog03);
    }

    //    http://localhost:1111/testbean/testDog2
    @GetMapping("/testDog2")
    public void testDog2() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class cl=Class.forName("com.goat.bean2.Dog");
        Object obj=cl.newInstance(); //通过 newInstance 创建一个无参数的 Dog 对象 (执行无参函数)
        System.out.println(obj);
    }
    /**
     http://localhost:1111/testbean/test2
     通过启动类 @ImportResource(locations = {"classpath:beans.xml"}) 注解  注入 该bean
    */
    @GetMapping("/test2")
    public void test2(){
        testService.test();
    }

    /**
     http://localhost:1111/testbean/test2
     通过@Service 注解 注入该 bean
     */
    @GetMapping("/test3")
    public void test3(){
        testService2.test();
    }

    /**  sos 实测 该方法  可以在拦截器中 注入 bean
     http://localhost:1111/testbean/test4
     通过启动类 FileSystemXmlApplicationContext  加载 该bean
     FileSystemXmlApplicationContext("beans.xml") 这种路径 虽然鼠标可以点击导航 但路径是不正确的 会报错  java.io.FileNotFoundException: beans.xml
     FileSystemXmlApplicationContext 适用于 配置文件 在 其他磁盘或是其他非 项目路径下 的情况
     ClassPathXmlApplicationContext("beans.xml") 是正常的   ClassPathXmlApplicationContext 才是默认在 类路径下 查找配置文件
     */
    @GetMapping("/test4")
    public void test4(){
        ApplicationContext ac = new FileSystemXmlApplicationContext("classpath:beans.xml");
        TestService testService = (TestService) ac.getBean("testoService");
        testService.test();
    }
    //   http://localhost:1111/testbean/test44
    @GetMapping("/test44")
    public void test44(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        Dog dog = (Dog) ac.getBean("dog01");
        System.out.println(dog);
    }

    //   http://localhost:1111/testbean/test41
    @GetMapping("/test41")
    public void test41(){
        ClassPathResource resource = new ClassPathResource("beans.xml");
        XmlBeanFactory xmlBeanFactory = new XmlBeanFactory(resource);
        Dog dog = (Dog) xmlBeanFactory.getBean("dog01");
        System.out.println(dog);
    }

    /** sos 实测 该方法  可以在拦截器中 注入 bean
     * http://localhost:1111/testbean/test5
     * 通过 implements ApplicationContextAware 获取 该bean
    */
    @GetMapping("/test5")
    public void test5(){
        TestService testoService1 = (TestService) SpringContextUtil.getBean("testoService");
        TestService testoService2 = (TestService) SpringContextUtil.getBean("testoService");
        assertThat(testoService1, sameInstance(testoService2)); // 判断两个对象 是否是同一个实例
        testoService1.test();
    }

    /**   http://localhost:1111/testbean/test55
     Expected: sameInstance(<com.goat.bean2.Dog@5195507d>)
     but: was <com.goat.bean2.Dog@6293e6e0>] with root cause
     说明 @bean 方法 配置了一次   在 bean.xml 中配置了一次  容器在启动的时候会给我们 new 出两个对象
     因为 容器是使用 new 方式来帮我们创建对象 所以 bean 必须要有 无参构造函数 否则报错：
     Parameter 0 of constructor in com.goat.bean2.Dog required a bean of type 'java.lang.String' that could not be found.
    */
    @GetMapping("/test55")
    public void test55(){
        Dog dog01 = (Dog) SpringContextUtil.getBean("dog01");
        Dog dog03 = (Dog) SpringContextUtil.getBean("dog03");
        assertThat(dog03, sameInstance(dog01)); // 判断两个对象 是否是同一个实例
    }

    /**   http://localhost:1111/testbean/test555
     * 同一个 组件 在ioc容器中 是单例的
     */
    @GetMapping("/test555")
    public void test555(){
        Dog dog01 = (Dog) SpringContextUtil.getBean("dog01");
        Dog dog03 = (Dog) SpringContextUtil.getBean("dog01");
        System.out.println(dog01 == dog03); // true
    }

    /**   sos 实测 该方法  不能 在拦截器中 注入 bean
     http://localhost:1111/testbean/test6
     通过 MyAppConfig 类的  @Configuration 和 @Bean 注解 注入该bean
     */
    @GetMapping("/test6")
    public void test6(){
        helloService.hello();
    }


}



