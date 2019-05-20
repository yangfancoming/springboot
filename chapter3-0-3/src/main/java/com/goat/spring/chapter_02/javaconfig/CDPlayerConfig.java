package com.goat.spring.chapter_02.javaconfig;


import com.goat.spring.chapter_02.ICompactDisc;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;


/**
 @Configuration 注解表明这个类是一个配置类， 该类应该包含在Spring应用上下文中如何创建bean的细节。
 比如说， 你想要将第三方库中的组件装配到你的应用中， 在这种情况下， 是没有办法在它的类上添加@Component和@Autowired注解的， 因此就不能使用自动化装配的方案了
 你必须要采用显式装配的方式。 在进行显式配置的时候， 有两种可选方案： Java和XML。
*/
@Configuration
public class CDPlayerConfig {

    /** @Bean注解会告诉Spring 将该方法的返回值 添加到spring容器 */
  @Bean
  public ICompactDisc sgtPeppers() {
    return new CompactDiscImpl2(); //  javaconfig 方式 声明bean的好处是 函数内 可以进行多重 if else 动态判断来加载不同的bean
  }
  /**
      在这里， cdPlayer()方法请求一个CompactDisc作为参数。 当
      Spring调用cdPlayer()创建CDPlayerbean的时候， 它会自动装配
      一个CompactDisc到配置方法之中。 然后， 方法体就可以按照合适
      的方式来使用它。 借助这种技术， cdPlayer()方法也能够
      将CompactDisc注入到CDPlayer的构造器中， 而且不用明确引
      用CompactDisc的@Bean方法。
  */

  @Bean(name = "cdPlayer") // 如果你想为其设置成一个不同的名字的话，可以通过name属性指定一个不同的名字
  public MediaPlayerImpl2 cdPlayer1(List<ICompactDisc> compactDisc) {
    return new MediaPlayerImpl2(compactDisc.get(0));
  }

  // 与上述 功能相同  只是写法不同 ，只是上述方法更易于理解
//    @Bean
//    public CDPlayer cdPlayer2() {
//        return new CDPlayer(sgtPeppers());
//    }
}
