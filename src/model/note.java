package model;

import java.util.Date;

public class note {

	private String title;
	private Date createDate;
	private Date changeDate;
	private String priority;
	private String text;

	public note(String title, String prio, String note) {
		this.title = title;
		this.createDate = new Date();
		this.changeDate = new Date();
		this.priority = prio; // 0 = low 1 = normal 2 = high
		this.text = note;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
