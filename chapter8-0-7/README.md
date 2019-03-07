#
    Kotlin会默认选择开启Spring框架的注解支持（比如，用@Configuration注解的类，@Service，@Component，@Repository等），
    但并不是必须的，可以根据选择引入。
    这里要特别注意一点，如果想在Kotlin中创建一个非final的类，我们则需要在类中添加open修饰符，比如：

#  注意： springboot  kotlin 工程目录结构  由原来的 src/main/java  变成 src/main/kotlin  否则 controller 类名均为灰色 而且 项目启动后  controller的mapping 均无法映射