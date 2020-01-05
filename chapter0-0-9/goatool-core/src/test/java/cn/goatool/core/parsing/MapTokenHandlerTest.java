package cn.goatool.core.parsing;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import static org.junit.Assert.assertEquals;

/**
 * Created by Administrator on 2020/1/5.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2020/1/5---16:34
 */
public class MapTokenHandlerTest {

    private TokenHandler initMap(){
        Map<String,String> map = new HashMap<>();
        map.put("first_name", "James");
        map.put("initial", "T");
        map.put("last_name", "Kirk");
        map.put("var{with}brace", "Hiya");
        map.put("", "");
        TokenHandler variableTokenHandler = new MapTokenHandler(map);
        return variableTokenHandler;
    }
    // HashMap方式： 解析失败 能够匹配 开合符  但是 Properties 中没有找到对应的值 则 直接返回 null
    @Test
    public void test33(){
        TokenHandler tokenHandler = new MapTokenHandler( new HashMap<>() );
        GenericTokenParser parser = new GenericTokenParser("${", "}", tokenHandler);
        assertEquals("null", parser.parse("${goat}"));
    }

    GenericTokenParser parser = new GenericTokenParser("${", "}", initMap());

    @Test
    public void tes111t2(){
        assertEquals("James T Kirk reporting.", parser.parse("${first_name} ${initial} ${last_name} reporting."));
        assertEquals("Hello captain James T Kirk", parser.parse("Hello captain ${first_name} ${initial} ${last_name}"));
        assertEquals("James T Kirk", parser.parse("${first_name} ${initial} ${last_name}"));
        assertEquals("JamesTKirk", parser.parse("${first_name}${initial}${last_name}"));
        assertEquals("{}JamesTKirk", parser.parse("{}${first_name}${initial}${last_name}"));
        assertEquals("}JamesTKirk", parser.parse("}${first_name}${initial}${last_name}"));

        assertEquals("}James{{T}}Kirk", parser.parse("}${first_name}{{${initial}}}${last_name}"));
        assertEquals("}James}T{Kirk", parser.parse("}${first_name}}${initial}{${last_name}"));
        assertEquals("}James}T{Kirk", parser.parse("}${first_name}}${initial}{${last_name}"));
        assertEquals("}James}T{Kirk{{}}", parser.parse("}${first_name}}${initial}{${last_name}{{}}"));
        assertEquals("}James}T{Kirk{{}}", parser.parse("}${first_name}}${initial}{${last_name}{{}}${}"));

        assertEquals("{$$something}JamesTKirk", parser.parse("{$$something}${first_name}${initial}${last_name}"));
        assertEquals("${", parser.parse("${"));
        assertEquals("${\\}", parser.parse("${\\}"));
        assertEquals("Hiya", parser.parse("${var{with\\}brace}"));
        assertEquals("", parser.parse("${}"));
        assertEquals("}", parser.parse("}"));
        assertEquals("Hello ${ this is a test.", parser.parse("Hello ${ this is a test."));
        assertEquals("Hello } this is a test.", parser.parse("Hello } this is a test."));
        assertEquals("Hello } ${ this is a test.", parser.parse("Hello } ${ this is a test."));
    }

}
