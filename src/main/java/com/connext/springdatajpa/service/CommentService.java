package com.connext.springdatajpa.service;

import com.connext.springdatajpa.model.Comment;

import java.util.List;

public interface CommentService {
    //根据文章id查询文章有关评论
    List<Comment> queryCommentByArticleId(Integer id);
    //添加评论
    void addComment(Comment comment);
    //删除自己的评论
    void deleteMyComment(Integer id);
}
