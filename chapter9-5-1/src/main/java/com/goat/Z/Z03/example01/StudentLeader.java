package com.goat.Z.Z03.example01;

import com.goat.Z.Z03.Student;

import java.util.List;

/**
 * Created by 64274 on 2019/5/6.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/5/6---13:58
 */
public class StudentLeader {

    private List<Student> students;
    public StudentLeader(List<Student> students){
        this.students = students;
    }
    public void counts(){
        System.out.println("体育委员开始清点人数......");
        int counts = students.size();
        System.out.println("体育委员清点结束，人数为"+counts);

    }
}
