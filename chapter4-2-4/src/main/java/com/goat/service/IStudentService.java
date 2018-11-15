package com.goat.service;

import com.goat.bean.Student;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IStudentService extends JpaRepository<Student, Integer> {
}
