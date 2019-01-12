package com.connext.springdatajpa.model;

import lombok.Data;
import org.hibernate.annotations.Formula;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Data
@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name="comment_content")
    private String commentContent;

    @JoinColumn(name = "message_id")
    @ManyToOne
    private Article article;

    @JoinColumn(name = "user_id")
    @ManyToOne
    private User user;

    private String phone;

    @CreatedDate
    private Date date;

    @Formula("(select u.username from user u where u.id=user_id)")
    private String username;



}
