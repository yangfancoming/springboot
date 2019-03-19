#@RunWith和@ContextConfiguration的作用
    @RunWith就是一个运行器
    @RunWith(JUnit4.class)就是指用JUnit4来运行
    @RunWith(SpringJUnit4ClassRunner.class),让测试运行于Spring测试环境
    @RunWith(Suite.class)的话就是一套测试集合，
    @ContextConfiguration Spring整合JUnit4测试时，使用注解引入多个配置文件
    
    单个文件 
    @ContextConfiguration(Locations="classpath：applicationContext.xml")  
    @ContextConfiguration(classes = SimpleConfiguration.class)
    
    多个文件时，可用{}
    @ContextConfiguration(locations = { "classpath:spring1.xml", "classpath:spring2.xml" }) 
