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
public class VariableTokenHandlerTest {

    private TokenHandler initProperties(){
        Properties properties = new Properties();
        properties.put("goat", "Sophia");
        properties.put("open", "close");
        properties.put("", "");
        TokenHandler variableTokenHandler = new VariableTokenHandler(properties);
        return variableTokenHandler;
    }

    TokenHandler tokenHandler = initProperties();

    // 自定义开合符 <> 测试
    @Test
    public void test(){
        GenericTokenParser parser = new GenericTokenParser("<", ">", tokenHandler);
        assertEquals("111  Sophia 111", parser.parse("111  <goat> 111"));
    }

    //  自定义开合符 *[] 测试
    @Test
    public void test1(){
        GenericTokenParser parser = new GenericTokenParser("*[", "]", tokenHandler);
        assertEquals("111  Sophia 111", parser.parse("111  *[goat] 111"));
    }

    // 解析失败  没有找到 开合符 按原结果输出   （设定的开合符为：*[ ] 而实际使用的是 [] 所以无法匹配）
    @Test
    public void test2(){
        GenericTokenParser parser = new GenericTokenParser("*[", "]", tokenHandler);
        assertEquals("111  [goat] 111", parser.parse("111  [goat] 111"));
    }

    // Properties方式： 解析失败 能够匹配 开合符  但是 Properties 中没有找到对应的值 则 套上 "${" + content + "}"; 后返回
    @Test
    public void test3(){
        TokenHandler tokenHandler = new VariableTokenHandler(new Properties());
        GenericTokenParser parser = new GenericTokenParser("*[", "]", tokenHandler);
        assertEquals("${goat}", parser.parse("*[goat]"));
    }

    // 测试 跳过符： \\    如果有开和符前使用 \\ 则只会忽略掉 一个开合符的解析，后面的开合符 不受影响
    @Test
    public void test4(){
        GenericTokenParser parser = new GenericTokenParser("*[", "]", tokenHandler);
        assertEquals("*[open]", parser.parse("\\*[open]"));
        assertEquals("close*[open]", parser.parse("*[open]\\*[open]"));
        //  \\ 则只会忽略掉 一个开合符的解析，后面的开合符 不受影响
        assertEquals("close*[open]close", parser.parse("*[open]\\*[open]*[open]"));
        //  非 \\ 跳过符 则不具有跳过功能
        assertEquals("close//closeclose", parser.parse("*[open]//*[open]*[open]"));
    }




}
