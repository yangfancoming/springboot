package com.goat.chapter258;

import com.goat.chapter258.msg.PersonBean;
import com.google.protobuf.InvalidProtocolBufferException;
import org.junit.Test;

/**
 * Created by Administrator on 2019/12/26.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/12/26---15:19
 */
public class App {

    @Test
    public void test() throws InvalidProtocolBufferException {
        PersonBean.Person person = PersonBean.Person.newBuilder().setName("zhangsan").setAge(20).setGender("male").build();
        byte[] bytes = person.toByteArray();
        PersonBean.Person temp = PersonBean.Person.parseFrom(bytes);
        System.out.println(temp);
    }
}
