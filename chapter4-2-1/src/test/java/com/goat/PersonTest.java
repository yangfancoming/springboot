package com.goat;


import com.goat.domain.Person;
import com.goat.domain.Pet;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;


@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonTest extends TestCommon  {

    // 单条 插入
    @Test
    public void savePet() {
        Pet pet = new Pet();
        pet.setAge(11);
        pet.setNickName("katie");
        pet = petRepository.save(pet);
        System.out.println(pet);
    }
    // 外键 插入
    @Test
    public void save1() { // doit  detached entity passed to persist: com.goat.domain.Pet
        Optional<Pet> temp = petRepository.findById(1L);
        Pet pet = temp.get();
        Person person = new Person();
        person.setAge(11);
        person.setName("hello");
        person.setPet(pet);
        person = personRepository.save(person);
        System.out.println(person);
    }
    // 外键 插入
    @Test
    public void save2() {
        Pet pet = new Pet();
        pet.setNickName("111");
        pet.setAge(123);
        Person person = new Person();
        person.setAge(11);
        person.setName("hello");
        person.setPet(pet);
        person = personRepository.save(person);
        System.out.println(person);
    }


    /**
         * @Description: 功能描述：(这里用一句话描述这个方法的作用)
         * @author: 杨帆
         * @Param:
         * @Return:
         * @Date:   2018/12/11
     *
     *  doit 这里查询后  person中的pet 并没有数据 还有问题
     *  本应该报错  javax.persistence. EntityNotFoundException: Unable to find Person with id 2
     *
     *  解决办法：
     * 1. 检查为什么子表中没有主表中ID对应的记录
     * 2. 如果子表中没有主表ID对应的记录也可以正常加载数据，那么需要在主表字段上加一个@NotFound Annotation。
     * 示例如下：
     * @OneToOne(optional=false)
     * @JoinColumn(name="business_id")
     * @NotFound(action=NotFoundAction.IGNORE)  这样，当子表中没找到数据时，主表中对应的field就是null，而不会报错了。
     *  private Business business;
    */
    @Test
    public void findAll() {
        List<Person> personList = personRepository.findAll();
        System.out.println(personList);
    }
}
