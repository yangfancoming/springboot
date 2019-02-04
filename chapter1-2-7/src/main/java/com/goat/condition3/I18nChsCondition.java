package com.goat.condition3;

import org.springframework.boot.autoconfigure.condition.ConditionOutcome;
import org.springframework.boot.autoconfigure.condition.SpringBootCondition;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.MethodMetadata;

/**
 * Created by 64274 on 2019/2/4.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/2/4---23:27
 */
//public class I18nChsCondition extends SpringBootCondition {
public class I18nChsCondition implements Condition {

//    @Override
//    public ConditionOutcome getMatchOutcome(ConditionContext context, AnnotatedTypeMetadata metadata) {
//        String lang = context.getEnvironment().getProperty("i18n.lang");
//        ConditionOutcome outCome = new ConditionOutcome("zh_CN".equals(lang), "i18n.lang=" + lang);
//        return outCome;
//    }

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        String lang = context.getEnvironment().getProperty("i18n.lang");
        return lang.contains("zh_CN");
    }
}
