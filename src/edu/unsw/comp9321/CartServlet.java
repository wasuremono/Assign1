package edu.unsw.comp9321;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Vector<SongBean> songList = new Vector<SongBean>();
		Vector<AlbumBean> albumList = new Vector<AlbumBean>();
		Vector<SongBean> newSongList = (Vector<SongBean>) request.getAttribute("cartSongList");
		Vector<AlbumBean> newAlbumList = (Vector<AlbumBean>) request.getAttribute("cartAlbumList");
		
		Vector<SongBean> duplicateSongInSong = new Vector<SongBean>();
		Vector<SongBean> duplicateSongInAlbum = new Vector<SongBean>();
		Vector<AlbumBean> duplicateAlbumInAlbum = new Vector<AlbumBean>();
		//Check song is not in album list, new or old
		for(SongBean newSong:newSongList){			
			for(AlbumBean newAlbum:newAlbumList){
				if(newAlbum.contains(newSong.getId())){
					duplicateSongInAlbum.add(newSong);
					break;
				}
			}
			
			for(AlbumBean existingAlbum:albumList){
				if(existingAlbum.contains(newSong.getId())){
					duplicateSongInAlbum.add(newSong);
					break;
				}
			}
			for(SongBean oldSong:songList){
				if(oldSong.contains(newSong.getSongId())){
					duplicateSongInSong.add(newSong);
					break;
				}
			}
		}
		for(AlbumBean newAlbum:newAlbumList){	
			for(AlbumBean existingAlbum:albumList){
				if(existingAlbum.contains(newAlbum.getId())){
					duplicateAlbumInAlbum.add(newAlbum);
					break;
				}
			}
		}
		response.getWriter().append("Cart has " +(newSongList.size()+newAlbumList.size()) + "items");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
