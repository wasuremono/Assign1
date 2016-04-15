<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
</body>
</html>