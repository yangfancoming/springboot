package com.goat.A04;

/**
 * Created by 64274 on 2018/12/19.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2018/12/19---20:51
 */
public class Student implements Comparable<Student>{
    public Integer Age;
    public String Name;

    public Integer getAge() {
        return Age;
    }
    public void setAge(int age) {
        Age = age;
    }

    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }

    public Student(int age,String name){
        this.Age = age;
        this.Name = name;
    }

    @Override
    public int compareTo(Student s) {
        //自定义比较方法，如果认为此实体本身大则返回1，否则返回-1
        if(this.Age >= s.getAge()){
            return 1;
        }
        return -1;
    }
}