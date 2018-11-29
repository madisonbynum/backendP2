package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="Staff")
public class Manager {
	@Column(name="email", unique=true)
	private String email;

	@Column(name="username", unique=true)
	 String username;

	private String password;

	private String role = "manager";
	
	
}
