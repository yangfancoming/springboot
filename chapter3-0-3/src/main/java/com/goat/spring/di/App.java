package com.goat.spring.di;

import com.goat.spring.di.config.KnightConfig;
import com.goat.spring.di.knight.BraveKnight;
import com.goat.spring.di.knight.DamselRescuingKnight;
import com.goat.spring.di.knight.Knight;
import com.goat.spring.di.quest.Quest;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.mockito.Mockito.*;

/**
 * Created by 64274 on 2018/7/27.
 *
 * @author 山羊来了
 * @Description: TODO
 * @date 2018/7/27---14:26
     需要注意的是，这个类中完全不知道是由哪个Knight来执行何种Quest任务，
     只有knights.xml文件知道,在xml文件可以 用 任意实现了 Quest接口的类 进行替换 注入 后使用
 */


public class App {
    @Test
    public void test0() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(KnightConfig.class);
        Knight knight = (Knight) ac.getBean("knight"); //
        knight.embarkOnQuest();
    }

    @Test
    public void test1() {
//        ApplicationContext ac = new AnnotationConfigApplicationContext(KnightConfig.class);
//        Knight knight = ac.getBean(Knight.class); // 这种方式  但这种方式  没能理解。。。
//        knight.embarkOnQuest();
    }

    @Test
    public void test2() {
        ClassPathXmlApplicationContext context =  new ClassPathXmlApplicationContext("knight.xml");
         Knight knight = (Knight) context.getBean("BraveKnight"); // 这种方式 我可以理解
        knight.embarkOnQuest();
        context.close();
    }

    @Test
    public void test3(){
        DamselRescuingKnight damselRescuingKnight = new DamselRescuingKnight();
        damselRescuingKnight.embarkOnQuest();
    }

    @Test
    public void knightShouldEmbarkOnQuest() {
        Quest mockQuest = mock(Quest.class); // 创建一个 Quest接口的mock实现
        BraveKnight knight = new BraveKnight(mockQuest); //  通过这个mock对象创建一个新的 BraveKnight 实例
        knight.embarkOnQuest();
        verify(mockQuest, times(1)).embark(); // 验证 Quest 的mock实现对象的embark()方法仅仅只被调用了一次
    }
}
