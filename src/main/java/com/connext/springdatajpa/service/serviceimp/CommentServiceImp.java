package com.connext.springdatajpa.service.serviceimp;

import com.connext.springdatajpa.repository.CommentRepository;
import com.connext.springdatajpa.model.Comment;
import com.connext.springdatajpa.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImp implements CommentService {

    @Autowired
    CommentRepository commentRepository;

    @Override
    public List<Comment> queryCommentByArticleId(Integer id) {
        return this.commentRepository.findAllByArticle_Id(id);
    }

    @Override
    public void addComment(Comment comment) {
        this.commentRepository.save(comment);
    }

    @Override
    public void deleteMyComment(Integer id) {
        this.commentRepository.deleteById(id);
    }
}
