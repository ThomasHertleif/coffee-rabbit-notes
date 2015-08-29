package model;

import java.util.Date;

public class note {

	private String title;
	private Date createDate;
	private Date changeDate;
	private byte priority;
	private String text;

	public note(String title, byte prio, String note) {
		this.title = title;
		this.createDate = new Date();
		this.changeDate = new Date();
		this.priority = prio; // 0 = low 1 = normal 2 = high
		this.text = note;
	}

	public byte getPriority() {
		return priority;
	}

	public void setPriority(byte priority) {
		this.priority = priority;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public Date getChangeDate() {
		return changeDate;
	}

}
