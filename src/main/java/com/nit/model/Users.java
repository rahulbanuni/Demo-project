package com.nit.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;


@Entity
@Table(name = "users")
@SuppressWarnings("serial")
public class Users implements Serializable {


	@Id
	@GeneratedValue
	@Column(name = "id", length = 11 )
	private Long id;
	
	@Size(min=1,message="required")  
	@Column(name = "user_name")
	String userName;
	
	@Size(min=1,message="required")  
	@Column(name = "user_password")
	String userPassword;


	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	} 



	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
}
