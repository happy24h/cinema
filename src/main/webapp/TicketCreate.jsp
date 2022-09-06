<%@page import="com.fpt.edu.entity.ShowTime"%>
<%@page import="com.fpt.edu.entity.Movie"%>
<%@page import="com.fpt.edu.entity.Room"%>
<%@page import="java.util.List"%>
<%@page import="com.fpt.edu.entity.TypeMovie"%>
<%@ page import="org.apache.jasper.tagplugins.jstl.core.ForEach" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<title>Ticket Create</title>
</head>
<body>
<center>
<table border="0" cellpadding="0" cellspacing="0">
		<tr>
			<h1>Create Ticket</h1>
			<td width="100%" height="133">&nbsp;
				<form method="POST" action="TicketCreate">
					<p align="left">
						rooms:
					</p>
					<%
						List<Room> rooms = (List<Room>) request.getAttribute("rooms");
					%>
					<select name="idRoom" id="idRoom">					
					<%
						for(Room item: rooms){
					%>
						<option value="<%=item.getId() %>"><%=item.getName() %></option>
					<%
						}
					%>
					</select>
					
					<p align="left">
						movies:
					</p>
					<%
						List<Movie> movies = (List<Movie>) request.getAttribute("movies");
					%>
					<select name="idMovie" id="idMovie">					
					<%
						for(Movie item: movies){
					%>
						<option value="<%=item.getId() %>"><%=item.getName() %></option>
					<%
						}
					%>
					</select>
					
					<p align="left">
						showtime:
					</p>
					<%
						List<ShowTime> showtimes = (List<ShowTime>) request.getAttribute("showtimes");
					%>
					<select name="idShowTime" id="idShowTime" style="margin-bottom: 10px">					
					<%
						for(ShowTime item: showtimes){
					%>
						<option value="<%=item.getId() %>"><%=item.getName() %> : <%=item.getPrice()%> Đồng</option>
					<%
						}
					%>
					</select>
					<input type="date" name="dateStart"/>
					<p align="left">
						<input class="btn btn-success" type="submit" value="Submit"> 
						<input class="btn btn-warning" type="reset" value="Reset">
						<a class="btn btn-info" style="margin: 10px;" href="MovieList">
							Danh sách phim
						</a>
					</p>
				</form>
				<p>
			</td>
		</tr>
	</table>
</center>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>