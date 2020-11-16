package com.uncopyrighted.uncopyrightedmain.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Song {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private String artist;
	private int released;
	private String genre;
	private String file;
	
	public Song() {
		super();
	}
	
	
	
	
	public Song(String name, String artist, int released, String genre, String file) {
		super();
		this.name = name;
		this.artist = artist;
		this.released = released;
		this.genre = genre;
		this.file = file;
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
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public int getReleased() {
		return released;
	}
	public void setReleased(int released) {
		this.released = released;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	
	public String getFile() {
		return file;
	}




	public void setFile(String file) {
		this.file = file;
	}




	@Override
	public String toString() {
		return "Song [id=" + id + ", name=" + name + ", artist=" + artist + ", released=" + released + ", genre="
				+ genre + ", file=" + file + "]";
	}




	
	
	
	
	
}
