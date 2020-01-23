package cn.goatool.core.parsing;

import org.junit.Test;

import java.util.Properties;

import static org.junit.Assert.assertEquals;

/**
 * Created by Administrator on 2020/1/5.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2020/1/5---15:32
 */
public class VariableTokenHandlerTest2 {

    private Properties initProperties(){
        Properties props = new Properties();
        props.setProperty("key", "value");
        props.setProperty("tableName", "members");
        props.setProperty("orderColumn", "member_id");
        props.setProperty("a:b", "c");
        return props;
    }

    Properties props = initProperties();

    // 替换测试
    @Test
    public void replaceToVariableValue1(){
        props.setProperty(VariableTokenHandler.KEY_ENABLE_DEFAULT_VALUE, "true");
        assertEquals("value",VariableTokenHandler.parse("${key}", props));
        assertEquals("aaaa",VariableTokenHandler.parse("${fuck:aaaa}", props));
        assertEquals("SELECT * FROM members ORDER BY member_id",VariableTokenHandler.parse("SELECT * FROM ${tableName:users} ORDER BY ${orderColumn:id}", props));
    }

    // 替换测试
    @Test
    public void replaceToVariableValue2(){

        props.setProperty(VariableTokenHandler.KEY_ENABLE_DEFAULT_VALUE, "false");
        assertEquals("c",VariableTokenHandler.parse("${a:b}", props));

        props.remove(VariableTokenHandler.KEY_ENABLE_DEFAULT_VALUE);
        assertEquals("c",VariableTokenHandler.parse("${a:b}", props));
    }

    //  不替换 测试
    @Test
    public void notReplace(){
        Properties props = new Properties();
        props.setProperty(VariableTokenHandler.KEY_ENABLE_DEFAULT_VALUE, "true");
        assertEquals("${key}",VariableTokenHandler.parse("${key}", props));
        assertEquals("${key}",VariableTokenHandler.parse("${key}", null));

        props.setProperty(VariableTokenHandler.KEY_ENABLE_DEFAULT_VALUE, "false");
        assertEquals("${a:b}",VariableTokenHandler.parse("${a:b}", props));
        props.remove(VariableTokenHandler.KEY_ENABLE_DEFAULT_VALUE);
        assertEquals("${a:b}",VariableTokenHandler.parse("${a:b}", props));
    }

    // 默认值测试
    @Test
    public void applyDefaultValue(){
        Properties props = new Properties();
        props.setProperty(VariableTokenHandler.KEY_ENABLE_DEFAULT_VALUE, "true");
        assertEquals("default",VariableTokenHandler.parse("${key:default}", props));
        assertEquals("SELECT * FROM users ORDER BY id",VariableTokenHandler.parse("SELECT * FROM ${tableName:users} ORDER BY ${orderColumn:id}", props));
        assertEquals(":",VariableTokenHandler.parse("${key::}", props));
        assertEquals(" ",VariableTokenHandler.parse("${key: }", props));
        assertEquals("",VariableTokenHandler.parse("${key:}", props));
    }

    // 自定义 分割符测试
    @Test
    public void applyCustomSeparator() {
        Properties props = new Properties();
        props.setProperty(VariableTokenHandler.KEY_ENABLE_DEFAULT_VALUE, "true");
        props.setProperty(VariableTokenHandler.KEY_DEFAULT_VALUE_SEPARATOR, "?:");

        assertEquals("default",VariableTokenHandler.parse("${key?:default}", props));
        assertEquals("SELECT * FROM users ORDER BY id",VariableTokenHandler.parse("SELECT * FROM ${tableName?:users} ORDER BY ${orderColumn?:id}", props));
        assertEquals(":",VariableTokenHandler.parse("${key?::}", props));
        assertEquals(" ",VariableTokenHandler.parse("${key?: }", props));
        assertEquals("",VariableTokenHandler.parse("${key?:}", props));
    }
}
