package cn.goatool.core.parsing;

import java.util.Properties;

/**
 * Created by Administrator on 2020/1/5.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2020/1/5---15:36
 */
public class VariableTokenHandler implements TokenHandler {

    private static final String KEY_PREFIX = "org.apache.ibatis.parsing.PropertyParser.";
    /**
     * The special property key that indicate whether enable a default value on placeholder.
     *   The default value is {@code false} (indicate disable a default value on placeholder)
     *   If you specify the {@code true}, you can specify key and default value on placeholder (e.g. {@code ${db.username:postgres}}).
     * @since 3.4.2
     * 特别的属性key,用于是否显示默认值的占位符
     * 特殊属性键，指示是否在占位符上启用默认值。
     * 默认值是false，是禁用的占位符上使用默认值，当启用以后（true）可以在占位符上使用默认值。
     * 例如：${db.username:postgres}，表示数据库的用户名默认是postgres
     */
    public static final String KEY_ENABLE_DEFAULT_VALUE = KEY_PREFIX + "enable-default-value";

    /** 为占位符上的键和默认值指定分隔符的特殊属性键。 默认分隔符是“:”
     *  #mark 特别的属性key,用于分割 key 和 默认值的占位符
     * The special property key that specify a separator for key and default value on placeholder.
     *   The default separator is {@code ":"}.
     * @since 3.4.2
     */
    public static final String KEY_DEFAULT_VALUE_SEPARATOR = KEY_PREFIX + "default-value-separator";
    /**
     * 是否开启默认值
     */
    private static final String ENABLE_DEFAULT_VALUE = "false";
    /**
     * 默认值分隔符
     */
    private static final String DEFAULT_VALUE_SEPARATOR = ":";

    // <properties> 节点下定义的键值对，用于替换占位符
    private final Properties variables;
    /**是否开启默认值*/
    private final boolean enableDefaultValue;
    /**默认分隔符*/
    private final String defaultValueSeparator;

     VariableTokenHandler(Properties variables) {
        this.variables = variables;
        this.enableDefaultValue = Boolean.parseBoolean(getPropertyValue(KEY_ENABLE_DEFAULT_VALUE, ENABLE_DEFAULT_VALUE));
        this.defaultValueSeparator = getPropertyValue(KEY_DEFAULT_VALUE_SEPARATOR, DEFAULT_VALUE_SEPARATOR);
    }

    private String getPropertyValue(String key, String defaultValue) {
        return (variables == null) ? defaultValue : variables.getProperty(key, defaultValue);
    }

    @Override
    public String handleToken(String content) {
        //如果variables不为空且存在key为content的property，就从variables中返回具体的值，否则在content两端添加上${和}
        if (variables != null) {
            String key = content;
            if (enableDefaultValue) { //开启默认值
                //分隔符索引值
                final int separatorIndex = content.indexOf(defaultValueSeparator);
                String defaultValue = null;
                if (separatorIndex >= 0) { //分隔符存在
                    //截取分隔符前面的key
                    key = content.substring(0, separatorIndex);
                    //截取默认值
                    defaultValue = content.substring(separatorIndex + defaultValueSeparator.length());
                }
                if (defaultValue != null) {  //存在默认值
                    //优先使用变量集合中的值，其次使用默认值
                    //获取properties对应的值，值不存在则返回默认值
                    return variables.getProperty(key, defaultValue);
                }
            }
            if (variables.containsKey(key)) {//未开启默认值
                return variables.getProperty(key);
            }
        }
        //以上都未匹配返回
        return "${" + content + "}";
    }
}

