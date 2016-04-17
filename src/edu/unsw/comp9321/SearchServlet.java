package edu.unsw.comp9321;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;
import java.util.logging.Logger;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;

/**
 * Servlet implementation class DOMServlet
 */
@WebServlet("/search")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Logger logger = Logger.getLogger(this.getClass().getName());  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String searchTerm = request.getParameter("searchTerm");
		String searchOption = request.getParameter("options");
		String addToCart[] = request.getParameterValues("selectedItems");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		//ServletContext context = getServletContext();
		String xmlLocation = null;
		InitialContext initialcontext;
		try {
			initialcontext = new InitialContext();
			xmlLocation = (String) initialcontext.lookup("java:comp/env/ConfigFile");
		} catch (NamingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//InputSource xmlFile = new InputSource(context.getResourceAsStream("/Assign1/WebContent/musicDb.xml"));
		Vector<SongBean>songs = new Vector<SongBean>();
		Vector<AlbumBean>albums = new Vector<AlbumBean>();
    	Vector<SongBean> songList = new Vector<SongBean>();
    	Vector<AlbumBean> albumList = new Vector<AlbumBean>();
    	Vector<SongBean> randomSongs = new Vector<SongBean>();
    	Vector<Integer> numSong = new Vector<Integer>();
    	Vector<SongBean> cartSongList = new Vector<SongBean>();
    	Vector<AlbumBean> cartAlbumList = new Vector<AlbumBean>();
	    try {	
	    	if(albums.isEmpty() && songList.isEmpty()){
	    		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
	    		DocumentBuilder builder = builderFactory.newDocumentBuilder();
	    		Document doc = builder.parse(xmlLocation);
	    		AlbumHandler aHandler = new AlbumHandler();
	    		SongHandler sHandler = new SongHandler();
	    		aHandler.translateToAlbum(doc, albums, songs);
	        	for(int i = 0; i < songs.size();i++ ){
	        		numSong.add(i);
	        	}
	    	}
	        //Search for Albums
	    	if(request.getParameterMap().containsKey("selectedItems")){
	    		cartSongList.clear();
	    		cartAlbumList.clear();
	    		for(String selectedItem: addToCart){
	    			for(SongBean song:songs){
	 	        		if(song.hasSong(selectedItem)){
	 	        			cartSongList.add(song);
	 	        			break;
	 	        		}
	 	        	}
	    			for(AlbumBean album:albums){
	 	        		if(album.contains(selectedItem)){
	 	        			cartAlbumList.add(album);
	 	        			break;
	 	        		}
	 	        	}
	    		}
	    		RequestDispatcher rd = request.getRequestDispatcher("/CartServlet");
	        	request.setAttribute("cartSongList", cartSongList);
	        	request.setAttribute("cartAlbumList", cartAlbumList);
	            rd.forward(request, response);
	    		
	    	}
	        if(!request.getParameterMap().containsKey("searchTerm")){
	        	randomSongs.clear();
	        	Collections.shuffle(numSong);
	        	
	        	for(int i =0;i<Math.min(10,songs.size());i++){
	        		randomSongs.add(songs.get(numSong.get(i)));
	        	}
	        	 RequestDispatcher rd = request.getRequestDispatcher("/search.jsp");
	        	 request.setAttribute("randomSongList", randomSongs);
	        	 rd.forward(request, response);
	        } else {
	        	RequestDispatcher rd = request.getRequestDispatcher("/results.jsp"); 

	        	 if(!searchOption.contains("Songs")){
	 	        	for(AlbumBean album:albums){
	 	        		if(album.contains(searchTerm)){
	 	        			albumList.add(album);
	 	        			
	 	        		}
	 	        	}
	 	        	request.setAttribute("albumList",albumList);

	 	        }
	 	        //Search for Songs
	 	        
	 	        if(!searchOption.contains("Album")){
	 	        	for(SongBean song:songs){
	 	        		if(song.contains(searchTerm)){
	 	        			songList.add(song);
	 	        			
	 	        		}
	 	        	}
	 	        	request.setAttribute("songList",songList);

	 	        
	 	        }
	 	        rd.forward(request, response);
	        }
	        
	   }
	   catch (Exception e) {
	        logger.severe(e.getMessage());
	   }

	}



}
