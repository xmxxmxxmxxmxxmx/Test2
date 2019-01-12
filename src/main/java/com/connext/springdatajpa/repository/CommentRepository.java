package com.connext.springdatajpa.repository;

import com.connext.springdatajpa.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CommentRepository extends JpaRepository<Comment,Integer> {
    List<Comment>  findAllByArticle_Id(Integer id);
}
