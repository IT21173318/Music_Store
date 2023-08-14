<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	String bookingId = request.getParameter("bookingId");
	String busSheduleId = request.getParameter("busScheduleId");
	String cutomerId = request.getParameter("customerId");
	String status = request.getParameter("status");
	%>

	<form action="deleteBookingDetails" method="post">
		<input type="number" name="bookId" value="<%=bookingId %>" readonly><br><br>
		<input type="number" name="bScheduleId" value="<%=busSheduleId %>" readonly><br><br>
		<input type="number" name="cusId" value="<%= cutomerId%>" readonly><br><br>
		<input type="number" name="Status" value="<%= status%>" readonly><br><br>
		<input type="submit" value="Delete" name="delete">
	</form>
</body>
</html>