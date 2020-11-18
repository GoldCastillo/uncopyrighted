package com.uncopyrighted.uncopyrightedmain.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class User {

	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userid", nullable = false, updatable = false)
	private long userid;

	@Column(name = "username", nullable = false, unique = true)
	private String username;

	@Column(name = "password", nullable = false)
	private String passwordHash;

	@Column(name = "role", nullable = false)
	private String role;

	@Column(name = "email", nullable = false)
	private String email;

	public User(String username, String passwordHash, String role, String email) {
		super();
		this.username = username;
		this.passwordHash = passwordHash;
		this.role = role;
		this.email = email;
	}

	public User() {

	}

	public long getUserid() {
		return userid;
	}

	public void setId(long userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
