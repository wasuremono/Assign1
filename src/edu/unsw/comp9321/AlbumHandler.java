package edu.unsw.comp9321;

import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Logger;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class AlbumHandler {
	Logger logger = Logger.getLogger(this.getClass().getName());
	
	public AlbumHandler(){}
	
	public void translateToAlbum(Document doc, Vector<AlbumBean> albums,Vector<SongBean> songs) {
		// TODO Auto-generated method stub	
		NodeList albumNodes = doc.getElementsByTagName("albumList");
		//Vector<AlbumBean> albums = new Vector<AlbumBean>();
		SongHandler handler = new SongHandler();
		
		for(int i=0;i<albumNodes.getLength();i++){
			AlbumBean album = new AlbumBean();
			//Vector<SongBean> songs = null;	
			Node n = albumNodes.item(i);
			boolean matchSearch = false;
			NodeList albumElements = n.getChildNodes();
			for(int j = 0; j < albumElements.getLength();j++){
				Node e = albumElements.item(j);
				if(e.getNodeName().equalsIgnoreCase("songlist")){				
					songs.add(handler.translateToSong(e,album));
					album.setSongList(songs);
				}
				if(e.getNodeName().equalsIgnoreCase("artist")){
					album.setArtist(e.getTextContent());					
				}
				if(e.getNodeName().equalsIgnoreCase("title")){
					album.setTitle(e.getTextContent());
				}
				if(e.getNodeName().equalsIgnoreCase("id")){
					album.setId(e.getTextContent());
				}
				if(e.getNodeName().equalsIgnoreCase("genre")){
					album.setGenre(e.getTextContent());
				}
				if(e.getNodeName().equalsIgnoreCase("publisher")){
					album.setPublisher(e.getTextContent());
				}
				if(e.getNodeName().equalsIgnoreCase("year")){
					album.setYear(e.getTextContent());
				}

				if(e.getNodeName().equalsIgnoreCase("price")){
					album.setPrice(Float.parseFloat(e.getTextContent()));
				}
			}
			albums.add(album);
		}
		
		return;
	}

}

