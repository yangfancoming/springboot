package com.goat.utils;

import com.google.common.base.Joiner;
import com.google.common.io.Files;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.joining;
import static org.hamcrest.core.IsEqual.equalTo;
import static com.google.common.collect.ImmutableMap.of;
import static org.hamcrest.core.IsSame.sameInstance;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

/**
 * Created by 64274 on 2019/2/16.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/2/16---9:38
 */
public class JoinerTest {

    private final List<String> stringList1 = Arrays.asList( "Google", "Guava", "Java", "Scala", "Kafka");
    private final List<String> stringList2 = Arrays.asList( "Google", "Guava", "Java", "Scala", null);
    private final String targetFileName = "E:\\Code\\J2EE_code\\MySpringBoot\\springboot\\chapter8-0-1\\src\\main\\resources\\test.txt";


    /**---------------------Guava 实现方式 -------------------------*/
    @Test
    public void test1() {
        String result = Joiner.on("#").join(stringList1); // 使用 # 来拼接数组
        assertThat(result, equalTo("Google#Guava#Java#Scala#Kafka"));
    }

    @Test(expected = NullPointerException.class) // 表明当这个方法抛出 NullPointerException 时 代表本次测试成功
    public void test2() {
        String result = Joiner.on("#").join(stringList2); // stringList2 中有 null 导致触发 空异常
        System.out.println(result);
    }
    @Test
    public void test3() {
        String result = Joiner.on("#").skipNulls().join(stringList2); // 跳过 null 值
        assertThat(result, equalTo("Google#Guava#Java#Scala"));
    }

    @Test
    public void test4() {
        String result = Joiner.on("#").useForNull("DEFAULT").join(stringList2); // 将 null 值 替换成 指定值
        assertThat(result, equalTo("Google#Guava#Java#Scala#DEFAULT"));
    }

    @Test
    public void test5() {
        final StringBuilder builder = new StringBuilder();
        StringBuilder resultBuilder = Joiner.on("#").useForNull("DEFAULT").appendTo(builder, stringList2);// 使用 appendTo
        assertThat(resultBuilder, sameInstance(builder)); // 判断两个对象 是否是同一个实例
        assertThat(resultBuilder.toString(), equalTo("Google#Guava#Java#Scala#DEFAULT"));
        assertThat(builder.toString(), equalTo("Google#Guava#Java#Scala#DEFAULT"));
    }

    @Test
    public void test6() {
        try (FileWriter writer = new FileWriter(new File(targetFileName))) {
            Joiner.on("#").useForNull("123").appendTo(writer, stringList2); // 将数据写入文件中
            assertThat(Files.isFile().apply(new File(targetFileName)), equalTo(true));
        } catch (IOException e) {
            fail("append to the writer occur fetal error.");
        }
    }

    /**---------------------Java8 实现方式 -------------------------*/

    @Test
    public void test7() {
        String result = stringList1.stream().filter(item -> item != null && !item.isEmpty()).collect(joining("#"));
        assertThat(result, equalTo("Google#Guava#Java#Scala#Kafka"));
    }
    @Test
    public void teset8() {
        String result = stringList2.stream().map(this::defaultValue).collect(joining("#"));
        assertThat(result, equalTo("Google#Guava#Java#Scala#DEFAULT"));
    }
    private String defaultValue(final String item) {
        return item == null || item.isEmpty() ? "DEFAULT" : item;
    }

    private final Map<String, String> stringMap = of("Hello", "Guava", "Java", "Scala");

    @Test
    public void testJoinOnWithMap() {
        assertThat(Joiner.on('#').withKeyValueSeparator("?").join(stringMap), equalTo("Hello?Guava#Java?Scala"));
    }

    private final String targetFileName2 = "E:\\Code\\J2EE_code\\MySpringBoot\\springboot\\chapter8-0-1\\src\\main\\resources\\test2.txt";
    @Test
    public void testJoinOnWithMapToAppendable() {
        try (FileWriter writer = new FileWriter(new File(targetFileName2))) {
            Joiner.on("#").withKeyValueSeparator("=").appendTo(writer, stringMap);
            assertThat(Files.isFile().apply(new File(targetFileName2)), equalTo(true));
        } catch (IOException e) {
            fail("append to the writer occur fetal error.");
        }
    }

}
