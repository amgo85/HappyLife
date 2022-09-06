package com.happylife.pojo;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="MESSAGES")
public class Messages {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="msgId", updatable = false, nullable = false)
	private long messageId;
	
	@Column(name="senderId", updatable = false, nullable = false)
	private long senderId;
	
	@Column(name="recipientId", updatable = false, nullable = false)
	private long recipientId;
	
	@Column(name="msgContent", updatable = false, nullable = false)
	private String msgContent;
	
	@Column(name="msgTime", updatable = false, nullable = false)
	private Timestamp time;
	
	@Column(name="msgRead", nullable = false)
	private boolean flag;
	
	@Column(name="msgApproved", nullable = false)
	private boolean approved;
	
	public Messages(){
		super();
	}
	
	public Messages(long messageId, long senderId, long recipientId, String msg, Timestamp ts, boolean flag, boolean approved) {
		super();
		this.messageId = messageId;
		this.senderId = senderId;
		this.recipientId = recipientId;
		this.msgContent = msg;
		this.time = ts;
		this.flag = flag;
		this.approved = approved;
	}
	
	public long getMessageId() {
		return messageId;
	}

	public void setMessageId(long msgId) {
		this.messageId = msgId;
	}
	
	public long getSenderId() {
		return senderId;
	}

	public void setSenderId(long messageId) {
		this.senderId = messageId;
	}
	
	public long getRecipientId() {
		return recipientId;
	}

	public void setRecipientId(long id) {
		this.recipientId = id;
	}
	
	public String getMsgContent() {
		return msgContent;
	}

	public void setMsgContent(String message) {
		this.msgContent = message;
	}
	
	public boolean getMessageStatus() {
		return flag;
	}

	public Timestamp getTime() {
		return time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	public void setMessageStatus(boolean status) {
		this.flag = status;
	}
}
