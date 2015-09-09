package model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Note {

	private String title;
	private LocalDateTime createDate;
	private LocalDateTime changeDate;
	private String priority;
	private String text;

	public Note(String title, String prio, String note) {
		this.title = title;
		this.createDate = LocalDateTime.now();
		this.changeDate = LocalDateTime.now();
		this.priority = prio;
		this.text = note;
	}
	
	public Note(String title, String prio, String note, String create, String change) {
		
		DateTimeFormatter dateFormatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
		this.title = title;
		this.createDate =  LocalDateTime.parse(create, dateFormatter);
		this.changeDate = LocalDateTime.parse(change, dateFormatter);
		this.priority = prio;
		this.text = note;
		
		this.updateChangeDate();
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

	public LocalDateTime getCreateDate() {
		return createDate;
	}

	public LocalDateTime getChangeDate() {
		return changeDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void updateChangeDate() {
		changeDate = LocalDateTime.now();
	}

	
	// Hmm cearial
	public String cearialize() {
		return "---\n" +
				"title: \"" + this.getTitle() +"\"\n" +
				"priority: \"" + this.getPriority() + "\"\n" +
				"created: \"" + this.getCreateDate().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME) + "\"\n" +
				"changed: \"" + this.getChangeDate().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME) + "\"\n" +
				"---\n" + this.getText() + "\n";
	}

}
