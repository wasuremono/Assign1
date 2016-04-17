<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="edu.unsw.comp9321.AlbumBean,edu.unsw.comp9321.SongBean, java.util.*" %>
<%@ taglib
    prefix="c"
    uri="http://java.sun.com/jsp/jstl/core" 
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
<center>
<H1>Welcome to Notes</H1>
What would you like to search for?
<Form Action = 'search' method = 'GET'>
<Select Name = "options" onchange="" Size = "1">
<Option value="Anything">Anything</Option>
<Option value="Album">Album</Option>
<Option value="Artist">Artist</Option>
<Option value="Songs">Songs</Option>
</Select>
<Input Type = "text" name = "searchTerm" value = "" size="20"/>
<Input Type = "submit" Value = "Search!">
</Form>
</center>
<p>

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
   	</tr>
   	<c:forEach var="song" items="${randomSongList}">
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
</body>
</html>