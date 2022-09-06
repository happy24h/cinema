<%@page import="java.util.List"%>
<%@page import="com.fpt.edu.entity.TypeMovie"%>
<%@ page import="org.apache.jasper.tagplugins.jstl.core.ForEach" %>
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
<title>Movie Create</title>
</head>
<body>
	<sql:setDataSource var = "testSQL" 
	driver = "com.mysql.cj.jdbc.Driver"
    url = "jdbc:mysql://localhost:3306/cinemadatabase?useUnicode=true&characterEncoding=utf-8"
    user = "root"  password = ""/>

    <sql:query dataSource = "${testSQL}" var = "result">
       SELECT * FROM type_movies;
    </sql:query>

	<center>
	<table border="0" cellpadding="0" cellspacing="0">
		<tr>
			<h1>Create Movie</h1>
			<td width="100%" height="133">&nbsp;
				<form method="POST" action="MovieCreate">
					<p align="left">
						Name: <input type="text" name="name" size="12">
					</p>
					<p align="left">
						Year: <input type="text" name="year" size="12">
					</p>

					<select name="idTypeMovie" id="typeMovies" style="margin-bottom: 10px">
						<c:forEach var="item" items = "${result.rows}">
			            	<option value="${item.id}">${ item.name}</option>
			         	</c:forEach>
					</select>
	
					<p align="left">
						link ảnh: <input type="text" name="link" >
					</p>
					<p align="left">
						description: <input type="text" name="description">
					</p>
					<p align="left">
						startTime: <input type="datetime-local" name="startTime" size="12">
					</p>
					<p align="left">
						endTime: <input type="datetime-local" name="endTime" size="12">
					</p>
					<p align="left">
						<input class="btn btn-success" type="submit" value="Submit"> 
						<input class="btn btn-warning" type="reset" value="Reset">
						<a class="btn btn-info" style="margin: 10px;" href="MovieList.jsp">
							Về danh sách phim
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