package com.goat.chapter453.service;

import com.goat.chapter453.entity.Comment;
import com.goat.chapter453.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2020/2/25.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2020/2/25---20:40
 */

@Service
public class CommentService {

    @Autowired
    CommentRepository commentRepository;

    public void saveComment(Comment comment){
        commentRepository.save(comment);
    }

    public void updateComment(Comment comment){
        commentRepository.save(comment);
    }

    public void deleteCommentById(String id){
        commentRepository.deleteById(id);
    }

    public List<Comment> findCommentList(){
        return commentRepository.findAll();
    }

    public Comment findCommentList(String id){
        return commentRepository.findById(id).get();
    }
}
