package com.happylife.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="viewed")
public class Viewed {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="id", updatable = false, nullable = false)
	private long id;
	
	@Column(name="uid1", nullable=false)
	private long uid1;
	
	@Column(name="uid2", nullable=false)
	private long uid2;
	
	@Column(name="historyContent", nullable=false)
	private String historyContent;
	
	@Column(name="user1vieweduser2")
	private boolean user1vieweduser2;
	
	@Column(name="user2vieweduser1")
	private boolean user2vieweduser1;
	
	@Column(name="user1inviteduser2")
	private boolean user1inviteduser2;
	
	@Column(name="user2inviteduser1")
	private boolean user2inviteduser1;
	
	@Column(name="user1Notes")
	private String user1notes;
	
	@Column(name="user2Notes")
	private String user2notes;
	
	public Viewed() {
		super();
	}
	

	public Viewed(long id, long uid1, long uid2, String historyContent, boolean user1vieweduser2,
			boolean user2vieweduser1, boolean user1inviteduser2, boolean user2inviteduser1) {
		super();
		this.id = id;
		this.uid1 = uid1;
		this.uid2 = uid2;
		this.historyContent = historyContent;
		this.user1vieweduser2 = user1vieweduser2;
		this.user2vieweduser1 = user2vieweduser1;
		this.user1inviteduser2 = user1inviteduser2;
		this.user2inviteduser1 = user2inviteduser1;
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getUid1() {
		return uid1;
	}

	public void setUid1(long uid1) {
		this.uid1 = uid1;
	}

	public long getUid2() {
		return uid2;
	}

	public void setUid2(long uid2) {
		this.uid2 = uid2;
	}

	public String getHistoryContent() {
		return historyContent;
	}

	public void setHistoryContent(String historyContent) {
		this.historyContent = historyContent;
	}

	public boolean hasUser1vieweduser2() {
		return user1vieweduser2;
	}

	public void setUser1vieweduser2(boolean user1vieweduser2) {
		this.user1vieweduser2 = user1vieweduser2;
	}

	public boolean hasUser2vieweduser1() {
		return user2vieweduser1;
	}

	public void setUser2vieweduser1(boolean user2vieweduser1) {
		this.user2vieweduser1 = user2vieweduser1;
	}

	public boolean hasUser1inviteduser2() {
		return user1inviteduser2;
	}

	public void setUser1inviteduser2(boolean user1inviteduser2) {
		this.user1inviteduser2 = user1inviteduser2;
	}

	public boolean hasUser2inviteduser1() {
		return user2inviteduser1;
	}

	public void setUser2inviteduser1(boolean user2inviteduser1) {
		this.user2inviteduser1 = user2inviteduser1;
	}

	public String getUser1notes() {
		return user1notes;
	}

	public void setUser1notes(String user1notes) {
		this.user1notes = user1notes;
	}

	public String getUser2notes() {
		return user2notes;
	}

	public void setUser2notes(String user2notes) {
		this.user2notes = user2notes;
	}
	
}
