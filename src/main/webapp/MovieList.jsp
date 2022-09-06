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
<title>Movie List</title>
</head>
<body>
	<c:if test="${not empty submitDone}">
	  <script>alert("Create Movie success");
	</script></c:if>

	<sql:setDataSource var = "testSQL" 
	driver = "com.mysql.cj.jdbc.Driver"
    url = "jdbc:mysql://localhost:3306/cinemadatabase?useUnicode=true&characterEncoding=utf-8"
    user = "root"  password = ""/>

    <sql:query dataSource = "${testSQL}" var = "result">
       SELECT * FROM movies;
    </sql:query>
	<a class="btn btn-info" style="margin: 10px;" href="MovieCreate">
		Tạo phim mới
	</a>
	<a class="btn btn-info" style="margin: 10px;" href="TicketCreate">
		Tạo vé cho phim
	</a>
	<a class="btn btn-info" style="margin: 10px;" href="TicketDashBoadTopMovie">
		Thống kê top phim theo ngày
	</a>
	<a class="btn btn-info" style="margin: 10px;" href="TicketDashBoadTopShowTime">
		Thống kê top khung giờ
	</a>
	
	<br/>
	<div>
	<c:forEach var="item" items = "${result.rows}">
     <div class="card" style="margin: 10px; width: 18rem; flex: auto; float: left">
	  <img src="${item.link}" class="card-img-top" alt="...">
	  <div class="card-body">
	    <h5 class="card-title">${item.name}</h5>
	    <p class="card-text">${item.description}</p>
	    <a href="TicketList?idMovie=${item.id}" class="btn btn-primary">Mua vé</a>
	  </div>
	</div>
   	</c:forEach>
	</div>
	
 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>