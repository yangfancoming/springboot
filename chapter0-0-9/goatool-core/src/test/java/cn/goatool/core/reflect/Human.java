package cn.goatool.core.reflect;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2019/12/5.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/12/5---9:51
 */
public class Human {

    private String name;

    public Integer age;

    public List<String> getIds(){
        return Arrays.asList("1","1","1");
    }

    /* 无参 无返回*/
    public void eat(){
        System.out.println("Human eat......");
    }

    /* 有参 无返回*/
    public void sing(String song){
        System.out.println("Human sing......" + song);
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }


}
