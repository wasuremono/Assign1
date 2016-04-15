package edu.unsw.comp9321;

import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Logger;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class SongHandler {
	Logger logger = Logger.getLogger(this.getClass().getName());
	
	public SongHandler(){}
	
	public SongBean translateToSong(Node s,AlbumBean album) {
		// TODO Auto-generated method stub		
		//NodeList songList = doc.getElementsByTagName("songList");
		NodeList song = s.getChildNodes();
		SongBean newSong = new SongBean(album);
		for(int i = 0; i < song.getLength();i++){		
			Node e = song.item(i);
			if(e.getNodeName().equalsIgnoreCase("artist")){
				newSong.setSongArtist(e.getTextContent());
			}
			if(e.getNodeName().equalsIgnoreCase("title")){
				newSong.setSongTitle(e.getTextContent());
			}
			if(e.getNodeName().equalsIgnoreCase("albumid")){
				newSong.setAlbumId(e.getTextContent());
				}
			if(e.getNodeName().equalsIgnoreCase("price")){
				newSong.setSongPrice(Float.parseFloat(e.getTextContent()));
			}
			if(e.getNodeName().equalsIgnoreCase("songid")){
				newSong.setSongId(e.getTextContent());
			}
				
			
		
		
		}
		return newSong;
	}	

}

