package com.happylife.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="message_approval")
public class MessageApproval {
	@Column(name="msgId", updatable = false, nullable = false)
	private long messageId;
	
	@Column(name="AdminId", updatable = false, nullable = false)
	private long adminId;
	
	@Column(name="msgApproved", updatable = false)
	private boolean msgApproved;

	public MessageApproval(long messageId, long adminId, boolean msgApproved) {
		super();
		this.messageId = messageId;
		this.adminId = adminId;
		this.msgApproved = msgApproved;
	}

	public long getMessageId() {
		return messageId;
	}

	public void setMessageId(long messageId) {
		this.messageId = messageId;
	}

	public long getAdminId() {
		return adminId;
	}

	public void setAdminId(long adminId) {
		this.adminId = adminId;
	}

	public boolean isMsgApproved() {
		return msgApproved;
	}

	public void setMsgApproved(boolean msgApproved) {
		this.msgApproved = msgApproved;
	}
	
}