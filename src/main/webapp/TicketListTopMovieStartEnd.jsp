<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<title>Thong ke top movie</title>
</head>
<body>
<center>
	<form method="get" action="TicketDashBoadTopMovie">
		Start: <input type="date" name="start"/>
		<br/>
		End: <input type="date" name="end"/>
		<p align="left">
			<input class="btn btn-success" type="submit" value="Submit"> 
			<input class="btn btn-warning" type="reset" value="Reset">
			<a class="btn btn-info" style="margin: 10px;" href="MovieList.jsp">
				Về danh sách phim
			</a>
		</p>
	</form>
</center>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>