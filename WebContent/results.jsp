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
<title>Insert title here</title>
</head>
<body>
   <c:if test="${searchOption != 'Songs'}">
   <c:choose>
   <c:when test="${not empty albumList}">
   <h1>List of Albums..</h1>
   <table>
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
   <table>
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
   		
   	</tr>			
   	</c:forEach>
 
   </table>
   </c:if>
</body>
</html>