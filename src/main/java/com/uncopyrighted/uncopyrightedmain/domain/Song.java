package com.uncopyrighted.uncopyrightedmain.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Song {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long songid;
	private String name;
	private String artist;
	private int released;
	private String genre;
	private String file;
	
	
	
	public Song(long songid, String name, String artist, int released, String genre, String file) {
		super();
		this.songid = songid;
		this.name = name;
		this.artist = artist;
		this.released = released;
		this.genre = genre;
		this.file = file;
	}
	public Song(String name, String artist, int released, String genre, String file) {
		super();
		this.name = name;
		this.artist = artist;
		this.released = released;
		this.genre = genre;
		this.file = file;
	}
	public Song() {
		super();
	}
	public long getSongid() {
		return songid;
	}
	public void setSongid(long songid) {
		this.songid = songid;
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
		return "Song [songid=" + songid + ", name=" + name + ", artist=" + artist + ", released=" + released
				+ ", genre=" + genre + ", file=" + file + "]";
	}
	
	
	
	




	
	
	
	
	
}
