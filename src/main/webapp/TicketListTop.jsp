<%@page import="com.fpt.edu.entity.TicketDashBoadTop"%>
<%@page import="com.fpt.edu.entity.Ticket"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<title>Thong Ke</title>
</head>
<body>

<table class="table">
	<thead class="thead-dark">
		<tr>
		    <th scope="col">Name</th>
		    <th scope="col">Total</th>
	  	</tr>
	</thead>
  <%
  List<TicketDashBoadTop> boadTopMovies = null;
  if(request.getAttribute("topMovies") !=null){
	  boadTopMovies = (List<TicketDashBoadTop>) request.getAttribute("topMovies");  
  }
  if(request.getAttribute("topShowTimes") !=null){
	  boadTopMovies = (List<TicketDashBoadTop>) request.getAttribute("topShowTimes");  
  }
  %>
  <%
  for(TicketDashBoadTop item: boadTopMovies){
  %>
		<tr>
	    <td><%=item.getName()%></td>
	    <td><%=item.getNum() %></td>
	  </tr>
	<%
		}
	%>
</table>
<a class="btn btn-info" style="margin: 10px;" href="MovieList.jsp">
							Về danh sách phim
						</a>
</body>
</html>