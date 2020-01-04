
package cn.goatool.db.type;

import java.lang.annotation.*;

// 注解配置 jdbc 数据类型
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface MappedJdbcTypes {
  JdbcType[] value();
  boolean includeNullJdbcType() default false;
}
