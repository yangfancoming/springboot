package com.goat.chapter453.repository;

import com.goat.chapter453.entity.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface CommentRepository extends MongoRepository<Comment, String> {


}
