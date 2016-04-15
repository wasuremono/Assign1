package edu.unsw.comp9321;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Logger;

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
		response.getWriter().append("Served at: ").append(request.getContextPath());
		//ServletContext context = getServletContext();
		
		//InputSource xmlFile = new InputSource(context.getResourceAsStream("/Assign1/WebContent/musicDb.xml"));
		Vector<SongBean>songs = new Vector<SongBean>();
		Vector<AlbumBean>albums = new Vector<AlbumBean>();
    	Vector<SongBean> songList = new Vector<SongBean>();
    	Vector<AlbumBean> albumList = new Vector<AlbumBean>();
	    try {	
	    	DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
	    	DocumentBuilder builder = builderFactory.newDocumentBuilder();
	        Document doc = builder.parse("http://www.cse.unsw.edu.au/~cs9321/16s1/assignments/ass1/musicDb.xml");
	        AlbumHandler aHandler = new AlbumHandler();
	        SongHandler sHandler = new SongHandler();
	        aHandler.translateToAlbum(doc, albums, songs);
	        //Search for Albums
	       
	        
	        request.setAttribute("searchOption",searchOption);
	        if(!request.getParameterMap().containsKey("searchTerm")){
	        	 RequestDispatcher rd = request.getRequestDispatcher("/search.jsp");
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
	 	        	System.out.println(songList.size());
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
