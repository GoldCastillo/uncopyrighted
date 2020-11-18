package com.uncopyrighted.uncopyrightedmain.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Picture {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long pictureid;
	private String name;
	private String subject;
	private String file;
	
	
	public Picture(String name, String subject, String file) {
		super();
		this.name = name;
		this.subject = subject;
		this.file = file;
	}
	public Picture(long pictureid, String name, String subject, String file) {
		super();
		this.pictureid = pictureid;
		this.name = name;
		this.subject = subject;
		this.file = file;
		
		
	}
	public Picture() {
		super();
	}
	public long getPictureid() {
		return pictureid;
	}
	public void setPictureid(long pictureid) {
		this.pictureid = pictureid;
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
		return "Picture [pictureid=" + pictureid + ", name=" + name + ", subject=" + subject + ", file=" + file + "]";
	}
	
	
	
	
	
}
