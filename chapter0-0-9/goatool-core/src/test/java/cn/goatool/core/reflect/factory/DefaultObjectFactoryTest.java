package cn.goatool.core.reflect.factory;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

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


    @Test
    public void creatHashMap() {
        Map  map = defaultObjectFactory.create(Map.class,null,null);
        Assert.assertTrue("Should be HashMap",map instanceof HashMap);
    }

    // 测试 通过 List Collection Iterable 接口创建的均为 ArrayList
    @Test
    public void createArrayList() {
        List list = defaultObjectFactory.create(List.class);
        Assert.assertTrue(" list should be ArrayList",list instanceof ArrayList);

        Collection collection = defaultObjectFactory.create(Collection.class);
        Assert.assertTrue(" collection should be ArrayList",collection instanceof ArrayList );

        Iterable iterable = defaultObjectFactory.create(Iterable.class);
        Assert.assertTrue(" iterable should be ArrayList",iterable instanceof ArrayList );
    }

    @Test
    void createTreeSet() {
        SortedSet sortedSet = defaultObjectFactory.create(SortedSet.class);
        Assert.assertTrue(" sortedSet should be TreeSet",sortedSet instanceof TreeSet );
    }

    @Test
    void createHashSet() {
        Set set = defaultObjectFactory.create(Set.class);
        Assert.assertTrue(" set should be HashSet",set instanceof HashSet );
    }

}
