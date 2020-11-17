package com.uncopyrighted.uncopyrightedmain.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Picture {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private String subject;
	private String file;
	public Picture(String name, String subject, String file) {
		super();
		this.name = name;
		this.subject = subject;
		this.file = file;
	}
	public Picture() {
		super();
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
	@Override
	public String toString() {
		return "Picture [id=" + id + ", name=" + name + ", subject=" + subject + ", file=" + file + "]";
	}
	
	
	
}
