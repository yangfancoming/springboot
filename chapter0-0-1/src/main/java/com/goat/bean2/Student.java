package com.goat.bean2;


import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by 64274 on 2018/8/24.
 *
 * @author 山羊来了
 * @Description: TODO
 * @date 2018年11月30日15:26:42
 */

public class Student {

    private String name;
    private Integer age;
    private Boolean sex;
    private Date bir;
    private Map<String,Object> location;
    private String[] hobbies;
    private List<String> skills;
    private Pet pet;

    @Override
    public String toString() {
        return "Student{" + "name='" + name + '\'' + ", age=" + age + ", sex=" + sex + ", bir=" + bir + ", location=" + location + ", hobbies=" + Arrays.toString(hobbies) + ", skills=" + skills + ", pet=" + pet + '}';
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

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public Date getBir() {
        return bir;
    }

    public void setBir(Date bir) {
        this.bir = bir;
    }

    public Map<String, Object> getLocation() {
        return location;
    }

    public void setLocation(Map<String, Object> location) {
        this.location = location;
    }

    public String[] getHobbies() {
        return hobbies;
    }

    public void setHobbies(String[] hobbies) {
        this.hobbies = hobbies;
    }

    public List<String> getSkill() {
        return skills;
    }

    public void setSkill(List<String> skills) {
        this.skills = skills;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }
}
