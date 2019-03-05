package com.goat.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 64274 on 2018/8/23.
 *
 * @author 山羊来了
 * @Description: TODO
 * @date 2018/8/23---17:27
 */
public class School {

    private String id;

    private String name;

    private List<User> students = new ArrayList<>();

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<User> getStudents() {
        return students;
    }
    public void setStudents(List<User> students) {
        this.students = students;
    }
}