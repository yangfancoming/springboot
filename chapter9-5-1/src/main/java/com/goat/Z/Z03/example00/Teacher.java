package com.goat.Z.Z03.example00;

import com.goat.Z.Z03.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 64274 on 2019/5/6.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/5/6---13:58
 */
public class Teacher {

    public void command(){
        System.out.println("老师接到命令，委托体育委员清点人数......");
        List<Student> students = new ArrayList<>();    //耦合了Students类
        for(int i = 0; i < 20; i++ ){
            students.add(new Student());
        }
        StudentLeader StudentLeader = new StudentLeader(); //耦合了StudentLeader类
        int counts = StudentLeader.counts(students);
        System.out.println("老师委托体育委员清点人数完毕......");
        System.out.println("老师报告学校领导，人数为"+counts);

    }
}
