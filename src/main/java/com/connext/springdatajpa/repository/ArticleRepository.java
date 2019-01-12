package com.connext.springdatajpa.repository;

import com.connext.springdatajpa.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface ArticleRepository extends JpaRepository<Article, Integer> {

    Integer countById(Integer userId);

    List<Article> findAllByUser_IdOrderByDateDesc(Integer userId);

    Article findAllById(Integer id);

    @Query(value = "select a.* from article a left join comment c on c.message_id=a.id group by a.id order by max(c.date)desc,a.date desc",nativeQuery = true)
    List<Article> findList();
}
