package com.goat.spring.di.config;

import com.goat.spring.di.knight.BraveKnight;
import com.goat.spring.di.knight.Knight;
import com.goat.spring.di.quest.Quest;
import com.goat.spring.di.quest.RescueDamselQuest;
import com.goat.spring.di.quest.SlayDragonQuest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
     * @Description: 功能描述：如果XML配置不符合你的喜好的话， Spring还支持使用Java来描述配置
     * @author: Goat
     * @Date:   2018/7/24
*/
@Configuration
public class KnightConfig {

    /* @Bean 注解会告诉Spring 将该方法的返回值 添加到spring容器中 容器中该组件的默认id为函数名 */
    @Bean
    public Quest quest() {
//        return new SlayDragonQuest(); // Embarking on quest to slay the dragon!
        return new RescueDamselQuest(); // Embarking on a quest to rescue the damsel.
    }

    @Bean
    public Knight knight() {
        return new BraveKnight(quest());
    }

}
