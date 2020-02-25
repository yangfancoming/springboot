package com.goat.chapter453.repository;

import com.goat.chapter453.entity.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface CommentRepository extends MongoRepository<Comment, String> {


    // 分页查询
    Page<Comment> findByParentid(String parentid, Pageable pageable);
}
