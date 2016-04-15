package edu.unsw.comp9321;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Vector;

public class AlbumBean implements Serializable{
	public String artist;
	public String title;
	public String id;
	public String genre;
	public String publisher;
	public String year;
	public Vector<SongBean> songList;
	public float price;
	
	
	
	public String getArtist() {
		return artist;
	}
	public String getTitle() {
		return title;
	}
	public String getId() {
		return id;
	}
	public String getGenre() {
		return genre;
	}
	public String getPublisher() {
		return publisher;
	}
	public String getYear() {
		return year;
	}
	public Vector<SongBean> getSongList() {
		return songList;
	}
	public float getPrice() {
		return price;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public void setSongList(Vector<SongBean> songList) {
		this.songList = songList;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	public boolean contains(String s){
		String lowerString = s.toLowerCase();
		if(this.artist.toLowerCase().contains(lowerString)){
			return true;
		}
		if(this.title.toLowerCase().contains(lowerString)){
			return true;
		}
		if(this.id.toLowerCase().contains(lowerString)){
			return true;
		}
		if(Float.toString(this.price).toLowerCase().contains(lowerString)){
			return true;
		}
		if(this.genre.toLowerCase().contains(lowerString)){			
			return true;
		}
		if(this.publisher.toLowerCase().contains(lowerString)){
			return true;
		}
		if(this.year.toLowerCase().contains(lowerString)){
			return true;
		}
		return false;
		
	}
	
}
