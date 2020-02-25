package com.goat.chapter453.service;

import com.goat.chapter453.entity.Comment;
import com.goat.chapter453.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
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

    public Page<Comment> findByParentid(String parentid, int page, int size){
        return commentRepository.findByParentid(parentid, PageRequest.of(page-1,size));
    }

    @Autowired
    MongoTemplate mongoTemplate;

    // 此种方式只打库一次，相对于先根据id查询出记录，点赞数+1后 再save来讲两次打库，效率高了很多
    public void updateCommentLikeNum(String id){
        // 查询条件
        Query query = Query.query(Criteria.where("_id").is(id));
        // 更新条件
        Update update = new Update();
        // 点赞数 增加步长为1
        update.inc("likenum",1);
        mongoTemplate.updateFirst(query,update,Comment.class);
    }
}
