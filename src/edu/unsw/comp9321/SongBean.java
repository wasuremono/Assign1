package edu.unsw.comp9321;

import java.io.Serializable;

public class SongBean extends AlbumBean implements Serializable {
	public String songId;
	public String songArtist;
	public String songTitle;
	public Float songPrice;

	
	public SongBean(AlbumBean album) {
		// TODO Auto-generated constructor stub
		this.artist = album.artist;
		this.genre = album.genre;
		this.id = album.id;
		this.publisher = album.publisher;
		this.price = album.price;
		this.title = album.title;
		this.year = album.year;
	}



	public String getSongId() {
		return songId;
	}


	public String getSongArtist() {
		return songArtist;
	}


	public String getSongTitle() {
		return songTitle;
	}


	public Float getSongPrice() {
		return songPrice;
	}




	public void setSongId(String songId) {
		this.songId = songId;
	}


	public void setSongArtist(String songArtist) {
		this.songArtist = songArtist;
	}


	public void setSongTitle(String songTitle) {
		this.songTitle = songTitle;
	}


	public void setSongPrice(Float songPrice) {
		this.songPrice = songPrice;
	}

    @Override
	public boolean contains(String s){
		String lowerString = s.toLowerCase();	
		if(this.songArtist.toLowerCase().contains(lowerString)){
			return true;
		}
		if(this.songTitle.toLowerCase().contains(lowerString)){
			return true;
		}
		if(this.id.toLowerCase().contains(lowerString)){
			return true;
		}
		if(Float.toString(this.songPrice).toLowerCase().contains(lowerString)){
			return true;
		}
		if(this.songId.toLowerCase().contains(lowerString)){
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
    
    public boolean hasSong(String s){
		String lowerString = s.toLowerCase();	
		if(this.songArtist.toLowerCase().contains(lowerString)){
			return true;
		}
		if(this.songTitle.toLowerCase().contains(lowerString)){
			return true;
		}
		if(Float.toString(this.songPrice).toLowerCase().contains(lowerString)){
			return true;
		}
		if(this.songId.toLowerCase().contains(lowerString)){
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
