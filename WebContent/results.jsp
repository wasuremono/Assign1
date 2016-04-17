<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="edu.unsw.comp9321.AlbumBean,edu.unsw.comp9321.SongBean, java.util.*" %>
<%@ taglib
    prefix="c"
    uri="http://java.sun.com/jsp/jstl/core" 
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<style type="text/css">
	.TFtable{
		width:100%; 
		border-collapse:collapse; 
	}
	.TFtable td{ 
		padding:7px; border:#4e95f4 1px solid;
	}
	/* provide some minimal visual accomodation for IE8 and below */
	.TFtable tr{
		background: #b8d1f3;
	}
	/*  Define the background color for all the ODD background rows  */
	.TFtable tr:nth-child(odd){ 
		background: #dae5f4;
	}
	/*  Define the background color for all the EVEN background rows  */
	.TFtable tr:nth-child(even){
		background: #FFFFFF;
	}
	.TFtable tr:nth-child(1){ 
		background: #cccccc;
	}
</style>

<title>Notes</title>
</head>
<body>
   <form action = 'search' method="get">
   <c:if test="${searchOption != 'Songs'}">
   
   <h1>List of Albums..</h1>
   <c:choose>
   <c:when test="${not empty albumList}">
   
   <table class ="TFtable">
   <tr>
   		<th>
   			Title
   		</th>
   		<th>
   			Artist
   		</th>
   		<th>
   			Genre
   		</th>
   		<th>
   			Publisher
   		</th>
   		<th>
   			Year
   		</th>
   		<th>
   			Price
   		</th>
   		<th>
   			Add to Cart
   		</th>
   	</tr>
   	<c:forEach var="album" items="${albumList}">
   	<tr>
   		<td>
   			${album.title}
   		</td>
   		<td>
   			${album.artist}
   		</td>
   		<td>
   			${album.genre}
   		</td>
   		<td>
   			${album.publisher}
   		</td>
   		<td>
   			${album.year}
   		</td>
   		<td>
   			${album.price}
   		</td>   	
   		<td>
   			<input type="checkbox" name="selectedItems" value="${album.id}"/> 
   		</td>
   	</tr>			
   	</c:forEach>   
   </table>

  
   </c:when>
   <c:otherwise>
   Sorry, no matching datasets found! Try different search string
   </c:otherwise>
   </c:choose>
   </c:if>
   
   <c:if test="${searchOption != 'Album'}">
   <h1>List of Songs..</h1>
   <c:choose>
   <c:when test="${not empty songList}">
   <table class = "TFtable">
   <tr>
   		<th>
   			Song Title
   		</th>
   		<th>
   			Song Artist
   		</th>
   		<th>
   			Album Title
   		</th>
   		<th>
   			Genre
   		</th>
   		<th>
   			Publisher
   		</th>
   		<th>
   			Year
   		</th>
   		<th>
   			Price
   		</th>
   		<th>
   			Add to Cart
   		</th>
   	</tr>
   	<c:forEach var="song" items="${songList}">
   	<tr>
   		<td>
   			${song.songTitle}
   		</td>
   		<td>
   			${song.songArtist}
   		</td>
   		<td>
   			${song.title}
   		</td>
   		<td>
   			${song.genre}
   		</td>
   		<td>
   			${song.publisher}
   		</td>
   		<td>
   			${song.year}
   		</td>
   		<td>
   			${song.songPrice}
   		</td>
   		<td>
   		   	<input type="checkbox" name="selectedItems" value="${song.songId}"/> 
   		</td>
   		
   	</tr>			
   	</c:forEach>
 
   </table>
   </c:when>
   <c:otherwise>
   Sorry, no matching datasets found! Try different search string
   </c:otherwise>
   </c:choose>
   </c:if>
   <p>
   </p>
   
   <c:if test="${not empty songList || not empty albumList}">
   <div align = "right">	 
   <Input Type = "submit" Value = "Add to Cart">   
   </c:if>
   </form>
   </div>
   <Form Action = 'search' method ='GET'>  
   <Input Type = "submit" Value = "Back to Search">   
   </Form>
   
</body>
</html>