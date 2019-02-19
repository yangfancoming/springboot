package com.goat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**

  这里会导致报错 Caused by: java.lang.IllegalArgumentException: Not a managed type: class java.lang.Object

 JpaRepository后边缺少指定类型 正确的应该是
 @Repository
 public interface TestRepository extends JpaRepository<User,Long>{
 }

*/

//public interface TestRepository extends JpaRepository {
//
//    @Query(value = "select u from t_user u where u.name = :name", nativeQuery = true)
//    Integer updateUserAgeIf(@Param("age") Integer age, @Param("id") Long id);
//
//}
//




