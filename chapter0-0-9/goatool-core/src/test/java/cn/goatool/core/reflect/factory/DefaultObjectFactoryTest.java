package cn.goatool.core.reflect.factory;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2020/1/5.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2020/1/5---14:12
 */
public class DefaultObjectFactoryTest {

    ObjectFactory defaultObjectFactory = new DefaultObjectFactory();

    ObjectFactory objectFactory = new DefaultObjectFactory();

    @Test
    public void test(){
        List<String> list = defaultObjectFactory.create(ArrayList.class);
        list.add("pear");
        list.add("apple");
        list.stream().forEach(x->System.out.println(x));
    }

    @Test
    public void testObjectFactory() {
        List<Integer> list = objectFactory.create(List.class);
        list.addAll(Arrays.asList(1, 2, 3));
        System.out.println(list);

        Map<String,String> map = objectFactory.create(Map.class);
        map.put("key", "value");
        map.put("key1", "value1");
        System.out.println(map);
    }

}
