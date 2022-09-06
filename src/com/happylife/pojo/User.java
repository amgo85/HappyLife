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
@Table(name="HL_USERS")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="userId", updatable = false, nullable = false)
	private long userId;
	
	@Column(name="FNAME", nullable = false)
	private String fname;
	
	@Column(name="LNAME", nullable = false)
	private String lname;
	
	@Column(name="EMAIL", nullable = false)
	private String email;
	
	//@NotBlank(message="Username can not be blank")
	@Column(name="username", nullable = false)
	private String username;
	
	@Size(min=6,message="Password must be atleast 6 characters long")
	@Column(name="PASSWD", nullable = false)
	private String password;
	
	@Column(name="GENDER", nullable = false)
	private String gender;
	
	@Column(name="LOOKINGIN", nullable = false)
	private String lookingIn;
	
	@Column(name="PHONE", nullable = false)
	private String phone;
	
	@Column(name="IMAGE", nullable = true)
	private String image;
	
	@Column(name="DOB", nullable = false)
	private Date dob;
	
	@Column(name="RESIDENCY_STATUS", nullable = true)
	private String residencyStatus;
	
	//@GeneratedValue(strategy = GenerationType.AUTO, generator = "year_gen")
	//@Column(name="Age", nullable = true)
	private int age;
	
	@Column(name="ABOUT_MYSELF", nullable = true)
	private String aboutMe;
	
	@Column(name="MY_FAV", nullable = true)
	private String myFavorites;
	
	@Column(name="PUBLIC_PHOTO", nullable = true)
	private String publicPhoto;
	
	@Column(name="LastLogin", updatable = true, nullable = true)
	private Timestamp lastLogin; 
	
	@Column(name="ProfilePostedBy", nullable = true)
	private String profilePostedBy;
	
	@Column(name="EthnicOrigin", nullable = true)
	private String ethnicOrigin;
	
	@Column(name="religiousHistory", nullable = true)
	private String religiousHistory;
	
	@Column(name="HairColor", nullable = true)
	private String hairColor;
	
	@Column(name="BodyType", nullable=true)
	private String bodyType;
	
	@Column(name="NOTIFICATIONS", nullable=true)
	private String notifications;
	
	@Column(name="Hijab_Beard", nullable = true)
	private String hijabBeard;
	
	@Column(name="Height", nullable = true)
	private String height;
	
	@Column(name="Pray", nullable = true)
	private String pray;
	
	@Column(name="Sect", nullable = true)
	private String sect;
	
	@Column(name="MaritalStatus", nullable = true)
	private String maritalStatus;
	
	@Column(name="Children", nullable = true)
	private String children;
	
	@Column(name="LikeToHaveChildren", nullable = true)
	private String likeToHaveChildren;
	
	@Column(name="Languages", nullable = true)
	private String languages;
	
	@Column(name="Profession", nullable = true)
	private String profession;
	
	@Column(name="HighestQual", nullable = true)
	private String highestQual;
	
	public User(){
		super();
	}
	
	public User(long userId, String fname, String lname, String email, String username, String password, String gender,
			String country, String phone, Date dob, String publicPhoto) {
		super();
		this.userId = userId;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.username = username;
		this.password = password;
		this.gender = gender;
		this.lookingIn = country;
		this.phone = phone;
		this.dob = dob;
		this.publicPhoto = publicPhoto;
	}	// used in sign up form
	
	/*
	 * public User(long userId, String fname, String lname, String email, String
	 * username, String password, String gender, String country, String phone,
	 * String image, String publicPhoto) { super(); this.userId = userId; this.fname
	 * = fname; this.lname = lname; this.email = email; this.username = username;
	 * this.password = password; this.gender = gender; this.country = country;
	 * this.phone = phone; this.image = image; this.publicPhoto = publicPhoto; } //
	 * used in login
	 */	
	public User(long userId, String fname, String lname, String email, String username, String gender,
			String country, String phone, String image, Date dob, String residencyStatus, String aboutMyself, String lookingFor, 
			String publicPhoto, Timestamp lastLogin, String profilePostedBy, String ethnicOrigin, String religiousHistory, 
			String hairColor, String bodyType, String notifications, String hijabBeard, String height, String pray, String sect, String maritalStatus, 
			String children, String likeToHaveChildren, String languages, String profession, String highestQual) {
		super();
		this.userId = userId;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.username = username;
		//this.password = password;
		this.gender = gender;
		this.lookingIn = country;
		this.phone = phone;
		this.image = image;
		this.dob = dob;
		this.residencyStatus = residencyStatus;
		this.aboutMe = aboutMyself;
		this.myFavorites = lookingFor;
		this.publicPhoto = publicPhoto;
		this.lastLogin = lastLogin;
		this.profilePostedBy = profilePostedBy;
		this.ethnicOrigin = ethnicOrigin;
		this.religiousHistory = religiousHistory;
		this.hairColor = hairColor;
		this.bodyType = bodyType;
		this.notifications = notifications;
		this.hijabBeard = hijabBeard;
		this.height = height;
		this.pray = pray;
		this.sect = sect;
		this.maritalStatus = maritalStatus;
		this.children = children;
		this.likeToHaveChildren = likeToHaveChildren;
		this.languages = languages;
		this.profession = profession;
		this.highestQual = highestQual;
	}	// used in viewcandid & searchby & login

	public long getUserId() {
		return userId;
	}

	public void setUserId(long id) {
		this.userId = id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getLookingIn() {
		return lookingIn;
	}

	public void setLookingIn(String country) {
		this.lookingIn = country;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getResidencyStatus() {
		return residencyStatus;
	}

	public void setResidencyStatus(String residencyStatus) {
		this.residencyStatus = residencyStatus;
	}

	public int getAge(Date date) {
		DoMath doM = new DoMath();
		return doM.getAge(date);
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAboutMe() {
		return aboutMe;
	}

	public void setAboutMe(String aboutMe) {
		this.aboutMe = aboutMe;
	}

	public String getMyFavorites() {
		return myFavorites;
	}

	public void setMyFavorites(String myFav) {
		this.myFavorites = myFav;
	}

	public String getPublicPhoto() {
		return publicPhoto;
	}

	public void setPublicPhoto(String publicPhoto) {
		this.publicPhoto = publicPhoto;
	}

	public Timestamp getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Timestamp lastLogin) {
		this.lastLogin = lastLogin;
	}

	public String getProfilePostedBy() {
		return profilePostedBy;
	}

	public void setProfilePostedBy(String profilePostedBy) {
		this.profilePostedBy = profilePostedBy;
	}

	public String getEthnicOrigin() {
		return ethnicOrigin;
	}

	public void setEthnicOrigin(String ethnicOrigin) {
		this.ethnicOrigin = ethnicOrigin;
	}

	public String getReligiousHistory() {
		return religiousHistory;
	}

	public void setReligiousHistory(String religiousHistory) {
		this.religiousHistory = religiousHistory;
	}

	public String getHairColor() {
		return hairColor;
	}

	public void setHairColor(String hairColor) {
		this.hairColor = hairColor;
	}

	public String getBodyType() {
		return bodyType;
	}

	public void setBodyType(String bodyType) {
		this.bodyType = bodyType;
	}

	public String getNotifications() {
		return notifications;
	}

	public void setNotifications(String notifications) {
		this.notifications = notifications;
	}

	public String getHijabBeard() {
		return hijabBeard;
	}

	public void setHijabBeard(String beard) {
		this.hijabBeard = beard;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getPray() {
		return pray;
	}

	public void setPray(String pray) {
		this.pray = pray;
	}

	public String getSect() {
		return sect;
	}

	public void setSect(String sect) {
		this.sect = sect;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getChildren() {
		return children;
	}

	public void setChildren(String children) {
		this.children = children;
	}

	public String getLikeToHaveChildren() {
		return likeToHaveChildren;
	}

	public void setLikeToHaveChildren(String likeToHaveChildren) {
		this.likeToHaveChildren = likeToHaveChildren;
	}
	
	public String getLanguages() {
		return languages;
	}

	public void setLanguages(String languages) {
		this.languages = languages;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getHighestQual() {
		return highestQual;
	}

	public void setHighestQual(String highestQual) {
		this.highestQual = highestQual;
	}
	
	
	
}
