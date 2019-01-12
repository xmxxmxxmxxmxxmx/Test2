package com.connext.springdatajpa.model;

import lombok.Data;
import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;


	private String phone;
	private String password;
	@Column(name = "user_type")
	private Integer usertype;
	private String username;

	@Formula("(select r.rolename from role r where r.id=user_type)")
	private String rolename;

	@Override
	public String toString() {
		return "User [id=" + id + ", phone=" + phone + ", password=" + password + ", username=" + username + "]";
	}



}
