package com.goat.Z.Z03.example00;

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

    //耦合了Students类
    public int counts(List<Student> students){
        System.out.println("体育委员开始清点人数......");
        int counts = students.size();
        System.out.println("体育委员清点结束，人数为"+counts+",并且返回人数给老师");
        return counts;
    }
}
