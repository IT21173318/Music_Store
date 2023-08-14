<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book</title>
</head>
<body>

	<form action="insertBookingDetails" method="post">
		Booking ID : <input type="number" name="bookingId"><br><br>
		Bus Schedule ID : <input type="number" name="busScheduleId"><br><br>
		Customer ID : <input type="number" name="customerId"><br><br>
		Status : <input type="number" name="status"><br><br>
		<input type="submit" name="submit" value="Submit">
	</form>
</body>
</html>