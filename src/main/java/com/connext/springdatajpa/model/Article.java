package com.connext.springdatajpa.model;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@EntityListeners(AuditingEntityListener.class)
@Entity
@Data
@Table(name = "article")
public class Article {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String messagetitle;
	private String messagedetail;

	@CreatedDate
	private Date date;
	private String photo;

	@OneToMany(mappedBy = "article")
	@OrderBy("date desc")
	private List<Comment> commentList;

	@JoinColumn(name = "user_id")
	@ManyToOne
	private User user;

	@Override
	public String toString() {
		return "Article{" +
				"id=" + id +
				", messagetitle='" + messagetitle + '\'' +
				", messagedetail='" + messagedetail + '\'' +
				", date=" + date +
				", photo='" + photo + '\'' +
				", commentList=" + commentList +
				", user=" + user +
				'}';
	}
}
