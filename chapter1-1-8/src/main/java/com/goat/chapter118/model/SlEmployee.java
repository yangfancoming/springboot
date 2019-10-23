package com.goat.chapter118.model;

/**
 * Created by 64274 on 2019/10/23.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/10/23---17:47
 */
public class SlEmployee implements java.io.Serializable {

    private static final long serialVersionUID = 4873217019660076767L;

    private SlDept slDept;

    private String name;

    private String age;


    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public SlEmployee() {
    }

    public SlDept getSlDept() {
        return slDept;
    }

    public void setSlDept(SlDept slDept) {
        this.slDept = slDept;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

