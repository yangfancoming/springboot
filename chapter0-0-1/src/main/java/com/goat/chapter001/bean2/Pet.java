package com.goat.chapter001.bean2;


/**
 * Created by 64274 on 2018/8/24.
 *
 * @author 山羊来了
 * @Description: TODO
 * @date 2018年11月30日15:26:58
 */
public class Pet {
    private String nickName;
    private Integer age;

    @Override
    public String toString() {
        return "Pet{" + "nickName='" + nickName + '\'' + ", age=" + age + '}';
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
