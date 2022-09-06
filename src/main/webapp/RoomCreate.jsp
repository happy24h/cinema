<%@page import="java.util.List"%>
<%@page import="com.fpt.edu.entity.TypeRoom"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table border="0" cellpadding="0" cellspacing="0">
		<tr>
			<h1>Create Room</h1>
			<td width="100%" height="133">&nbsp;
				<form method="POST" action="RoomCreate">
					<p align="left">
						name: <input type="text" name="name" size="12">
					</p>
					<p align="left">
						rowRoom: <input type="number" name="rowRoom" size="12">
					</p>
					<p align="left">
						columnRoom: <input type="number" name="columnRoom" size="12">
					</p>
					<%
						List<TypeRoom> typeRooms = (List<TypeRoom>) request.getAttribute("typeRooms");
					%>
					<select name="idTypeRoom" id="idTypeRoom">					
					<%
						for(TypeRoom item: typeRooms){
					%>
						<option value="<%=item.getId() %>"><%=item.getName() %></option>
					<%
						}
					%>
					</select>
					<p align="left">
						<input type="submit" value="Submit"> 
						<input type="reset" value="Reset">
					</p>
				</form>
				<p>
			</td>
		</tr>
	</table>
</body>
</html>