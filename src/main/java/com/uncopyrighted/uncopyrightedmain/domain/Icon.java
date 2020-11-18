package com.uncopyrighted.uncopyrightedmain.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Icon {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long iconid;
	private String name;
	private String file;
	public long getIconid() {
		return iconid;
	}
	public void setIconid(long iconid) {
		this.iconid = iconid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
	public Icon(long iconid, String name, String file) {
		super();
		this.iconid = iconid;
		this.name = name;
		this.file = file;
	}
	
	public Icon(String name, String file) {
		super();
		this.name = name;
		this.file = file;
	}
	public Icon() {
		super();
	}
	@Override
	public String toString() {
		return "Icon [iconid=" + iconid + ", name=" + name + ", file=" + file + "]";
	}
	
	
	
	
}
