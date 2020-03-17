package com.goat.example03;

import java.util.List;

/**
 * Created by 64274 on 2018/9/13.
 * @author 山羊来了
 * @Description: TODO
 * @date 2018/9/13---19:27
 */
class Student {

    private String name;
    private String age;
    private int gender;
    private String school;
    private List<Course> grade;

    public List<Course> getGrade() {
        return grade;
    }

    public void setGrade(List<Course> grade) {
        this.grade = grade;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    @Override
    public String toString() {
        StringBuilder grades = null;
        for (Course course : grade) {
            grades.append(course.toString());
        }
        return "name:" + getName() + " age:" + getAge() + " gender:" + getGender() + " school:" + getSchool() + "grade:" + grades;
    }
}