<%@page import="com.fpt.edu.entity.Ticket"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/sql" prefix = "sql"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<title>Ticket List</title>
</head>
<body>
<table class="table">
  <thead class="thead-dark">
    <tr>
      <th scope="col">Id</th>
      <th scope="col">Name Movie</th>
      <th scope="col">ShowTime</th>
      <th scope="col">StartTime</th>
      <th scope="col">Price</th>
      <th scope="col">Status</th>
    </tr>
  </thead>
    <%
	int idMovie = Integer.valueOf(request.getParameter("idMovie"));
  %>
  <%
	List<Ticket> tickets = (List<Ticket>) request.getAttribute("tickets");
  %>

  <%
		for(Ticket item: tickets){
	%>
		<tr>
	    <td><%=item.getId()%></td>
	    <td>
		<%
		Class.forName("com.mysql.jdbc.Driver");

		Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/cinemadatabase?useUnicode=true&characterEncoding=utf-8", 
				"root", 
				"");
		Statement st = conn.createStatement();
		
		String findMovieDetail = "SELECT * FROM movie_details Where id = " + item.getIdMovieDetail();;
		ResultSet findMovieDetailById = st.executeQuery(findMovieDetail);
		int idMovieOfMovieDetail = 0;
	    if (findMovieDetailById != null && findMovieDetailById.next()) {
	    	idMovieOfMovieDetail = findMovieDetailById.getInt("idMovie");
	    }
		
		String findMovie = "SELECT * FROM movies Where id = " + idMovieOfMovieDetail;
		ResultSet findMovieById = st.executeQuery(findMovie);
		%>
		 <%
		    String nameMovie = "";
		    if (findMovieById != null && findMovieById.next()) {
		    	nameMovie = findMovieById.getString("name");
		    }
		%>
    	<%= nameMovie %>
	    </td>
	    <td>
	    <%
	    String findShowTime = "SELECT * FROM showtimes Where id = " + item.getIdShowTime();
		ResultSet findShowTimeId = st.executeQuery(findShowTime);
	    %>
	    <%
		    String nameShowTime = "";
		    if (findShowTimeId != null && findShowTimeId.next()) {
		    	nameShowTime = findShowTimeId.getString("name");
		    }
		%>
    	<%= nameShowTime %>
	    </td>
	    <td><%=item.getDateStart() %></td>
	    <td><%=item.getPrice() %></td>
	    <td>
	    	<% switch(item.getStatus())
	    	{
	    		case 1: 
	    			out.println("Bán");
	    			break;
	    		case 2: 
	    			out.println("Đã mua");
	    			break;
	    		case 3: 
	    			out.println("Hoàn trả");
	    			break;
	    	} %>
	    </td>
	    
	    <td>
	    <% switch(item.getStatus())
	    	{
	    		case 1: %>
	    			<a href="TicketBuy?id=<%=item.getId() %>&idMovie=<%=idMovie %>">Buy</a>
	    			<%
	    			break;
	    		case 2: 
	    			%>
	    			<a href="TicketRefund?id=<%=item.getId() %>&idMovie=<%=idMovie %>">Refund</a>
	    			<%
	    			break;
	    		case 3: 
	    			out.println("Hoàn trả");
	    			break;
	    	} %>
	    </td>
	  </tr>
	<%
		}
	%>
</table>
<a class="btn btn-info" style="margin: 10px;" href="MovieList.jsp">
							Về danh sách phim
						</a>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>