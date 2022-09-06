package com.happylife.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="LOOKING_FOR")
public class LookingFor {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="ID", updatable = false, nullable = false)
	private long id;
	
	@Column(name="userId", updatable = false, nullable = false)
	private long userId;
	
	@Column(name="AgeL", nullable = true)
	private String ageL;
	
	@Column(name="AgeH", nullable = true)
	private String ageH;
	
	@Column(name="LOOKINGIN", nullable = true)
	private String lookingIn;
	
	@Column(name="RESIDENCY_STATUS", nullable = true)
	private String residencyStatus;
	
	@Column(name="WILLING_TO_RELOCATE", nullable = true)
	private String willingToRelocate;
	
	@Column(name="EthnicOrigin", nullable = true)
	private String ethnicOrigin;
	
	@Column(name="religiousHistory", nullable = true)
	private String religiousHistory;
	
	@Column(name="Living_With_InLaws", nullable = true)
	private String livingWithInLaws;
	
	@Column(name="Pray", nullable = true)
	private String pray;
	
	@Column(name="Sect", nullable = true)
	private String sect;
	
	@Column(name="MaritalStatus", nullable = true)
	private String maritalStatus;
	
	@Column(name="HasChildren", nullable = true)
	private String hasChildren;
	
	@Column(name="HasPDisability", nullable = true)
	private String hasPDisability;
	
	@Column(name="LikeToHaveChildren", nullable = true)
	private String likeToHaveChildren;
	
	@Column(name="Polygamy", nullable = true)
	private String polygamy;
	
	@Column(name="BodyType", nullable = true)
	private String bodyType;
	
	@Column(name="HeightL", nullable = true)
	private String heightL;
	
	@Column(name="HeightH", nullable = true)
	private String heightH;
	
	@Column(name="Hijab_Beard", nullable = true)
	private String hijabBeard;
	
	@Column(name="Profession", nullable = true)
	private String profession;
	
	@Column(name="MinimumQual", nullable = true)
	private String minimumQual;
	
	@Column(name="LOOKING_FOR", nullable = true)
	private String lookingFor;
	
	public LookingFor() {
	}
	
	public LookingFor(long id, long userId) {
		this.id = id;
		this.userId = userId;
	}

	public LookingFor(long id, long userId, String ageL, String ageH, String lookingIn, String residencyStatus,
			String willingToRelocate, String ethnicOrigin, String religiousHistory, String livingWithInLaws,
			String pray, String sect, String maritalStatus, String children, String hasPDisability,
			String likeToHaveChildren, String polygamy, String bodyType, String heightL, String heightH,
			String hijabBeard, String profession, String highestQual, String lookingFor) {
		
		this.id = id;
		this.userId = userId;
		this.ageL = ageL;
		this.ageH = ageH;
		this.lookingIn = lookingIn;
		this.residencyStatus = residencyStatus;
		this.willingToRelocate = willingToRelocate;
		this.ethnicOrigin = ethnicOrigin;
		this.religiousHistory = religiousHistory;
		this.livingWithInLaws = livingWithInLaws;
		this.pray = pray;
		this.sect = sect;
		this.maritalStatus = maritalStatus;
		this.hasChildren = children;
		this.hasPDisability = hasPDisability;
		this.likeToHaveChildren = likeToHaveChildren;
		this.polygamy = polygamy;
		this.bodyType = bodyType;
		this.heightL = heightL;
		this.heightH = heightH;
		this.hijabBeard = hijabBeard;
		this.profession = profession;
		this.minimumQual = highestQual;
		this.lookingFor = lookingFor;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getAgeL() {
		return ageL;
	}

	public void setAgeL(String ageL) {
		this.ageL = ageL;
	}

	public String getAgeH() {
		return ageH;
	}

	public void setAgeH(String ageH) {
		this.ageH = ageH;
	}

	public String getLookingIn() {
		return lookingIn;
	}

	public void setLookingIn(String lookingIn) {
		this.lookingIn = lookingIn;
	}

	public String getResidencyStatus() {
		return residencyStatus;
	}

	public void setResidencyStatus(String residencyStatus) {
		this.residencyStatus = residencyStatus;
	}

	public String getWillingToRelocate() {
		return willingToRelocate;
	}

	public void setWillingToRelocate(String willingToRelocate) {
		this.willingToRelocate = willingToRelocate;
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

	public String getLivingWithInLaws() {
		return livingWithInLaws;
	}

	public void setLivingWithInLaws(String livingWithInLaws) {
		this.livingWithInLaws = livingWithInLaws;
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

	public String getHasChildren() {
		return hasChildren;
	}

	public void setHasChildren(String hasChildren) {
		this.hasChildren = hasChildren;
	}

	public String getHasPDisability() {
		return hasPDisability;
	}

	public void setHasPDisability(String hasPDisability) {
		this.hasPDisability = hasPDisability;
	}

	public String getLikeToHaveChildren() {
		return likeToHaveChildren;
	}

	public void setLikeToHaveChildren(String likeToHaveChildren) {
		this.likeToHaveChildren = likeToHaveChildren;
	}

	public String getPolygamy() {
		return polygamy;
	}

	public void setPolygamy(String polygamy) {
		this.polygamy = polygamy;
	}

	public String getBodyType() {
		return bodyType;
	}

	public void setBodyType(String bodyType) {
		this.bodyType = bodyType;
	}

	public String getHeightL() {
		return heightL;
	}

	public void setHeightL(String heightL) {
		this.heightL = heightL;
	}

	public String getHeightH() {
		return heightH;
	}

	public void setHeightH(String heightH) {
		this.heightH = heightH;
	}

	public String getHijabBeard() {
		return hijabBeard;
	}

	public void setHijabBeard(String hijabBeard) {
		this.hijabBeard = hijabBeard;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getMinimumQual() {
		return minimumQual;
	}

	public void setMinimumQual(String minimumQual) {
		this.minimumQual = minimumQual;
	}

	public String getLookingFor() {
		return lookingFor;
	}

	public void setLookingFor(String lookinFor) {
		this.lookingFor = lookinFor;
	}
}
