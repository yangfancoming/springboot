package com.goat.service;

import com.goat.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IStudentService extends JpaRepository<Student, Integer> {

//    Page<List<Map<String,Object>>> findForMap(Pageable pageable);
}
