package com.goat.chapter453.controller;

import com.goat.chapter453.entity.Comment;
import com.goat.chapter453.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by Administrator on 2020/2/25.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2020/2/25---20:48
 */
@RestController
public class CommentController {

    @Autowired
    CommentService commentService;

    // 测试地址：    http://localhost:8453/comment1
    @GetMapping("/comment1")
    public void findCommentList() {
        List<Comment> commentList = commentService.findCommentList();
        System.out.println(commentList.size());
    }

    // 测试地址：    http://localhost:8453/comment2
    @GetMapping("/comment2")
    public void saveComment() {
        Comment comment = new Comment();
        comment.setArticleId("1");
        comment.setContent("content");
        comment.setCreatedatetime(LocalDateTime.now());
        comment.setLikenum(1);
        comment.setReplynum(1);
        comment.setNickname("nickname");
        comment.setParentid("0");
        comment.setUserid("1");
        comment.setState("0");
        commentService.saveComment(comment);
    }



    // 测试地址：    http://localhost:8453/comment3
    @GetMapping("/comment3")
    public void findByParentid() {
        Page<Comment> temp = commentService.findByParentid("0",1,5);
        System.out.println(temp.getTotalPages());
        System.out.println(temp.getTotalElements());
        System.out.println(temp.getContent().size());
    }

}
