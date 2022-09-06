package com.happylife.pojo;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="reset_pass")
public class ResetPass {
	
	@Column(name="TOKEN", nullable = false)
	private String token;
	
	@Column(name="EMAIL", nullable = false)
	private String email;
	
	@Column(name="CREATION_TIME", nullable = false)
	private Timestamp creationTime;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Timestamp getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Timestamp creationTime) {
		this.creationTime = creationTime;
	}
	
}
