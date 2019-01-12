package com.connext.springdatajpa.service;

import com.connext.springdatajpa.model.Comment;

import java.util.List;

public interface CommentService {
    //��������id��ѯ�����й�����
    List<Comment> queryCommentByArticleId(Integer id);
    //�������
    void addComment(Comment comment);
    //ɾ���Լ�������
    void deleteMyComment(Integer id);
}
