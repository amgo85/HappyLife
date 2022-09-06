package com.happylife.pojo;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.happylife.DoMath;

@Entity
@Table(name="Admins")
public class Admin {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="AdminId", updatable = false, nullable = false)
	private int adminId;
	
	@Column(name="EMAIL", nullable = false)
	private String email;
	
	@Column(name="FNAME", nullable = false)
	private String fname;
	
	@Column(name="LNAME", nullable = false)
	private String lname;
	
	//@NotBlank(message="Username can not be blank")
	@Column(name="username", nullable = false)
	private String username;
	
	@Size(min=6,message="Password must be atleast 6 characters long")
	@Column(name="PASSWD", nullable = false)
	private String password;
	
	@Column(name="GENDER", nullable = false)
	private String gender;
	
	@Column(name="DOB", nullable = false)
	private Date dob;
	
	@Column(name="PHONE", nullable = false)
	private String phone;
	
	public Admin(){
		super();
	}
	
	public Admin(int adminId, String email, String fname, String lname, String username, String password, String gender,
			 Date dob, String phone) {
		super();
		this.adminId = adminId;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.username = username;
		this.password = password;
		this.gender = gender;
		this.phone = phone;
		this.dob = dob;
	}	// used in sign up form
		
	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int id) {
		this.adminId = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public int getAge(Date date) {
		DoMath doM = new DoMath();
		return doM.getAge(date);
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}	
}
