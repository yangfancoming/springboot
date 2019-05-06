package com.goat.Z.Z03.example01;

import com.goat.Z.Z03.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 64274 on 2019/5/6.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/5/6---13:59
 */
public class App {

    public static void main(String[] args){
        System.out.println("周末收假，学校领导命令老师去点名.....");
        List<Student> students = new ArrayList<>();
        for(int i = 0; i < 20; i++ ){
            students.add(new Student());
        }
        Teacher teacher = new Teacher();
        teacher.command(new StudentLeader(students));
    }
}
