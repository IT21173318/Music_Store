<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Booking Details</title>
</head>
<body>
	
	<h1>Booking Details</h1>
	<c:forEach var="book" items="${bookingDetails}">
	
	<c:set var="bookId" value="${book.bookingId}"></c:set>
	<c:set var="busSchedId" value="${book.busScheduleId}"></c:set>
	<c:set var="cusId" value="${book.customerId}"></c:set>
	<c:set var="status" value="${book.status}"></c:set> 
	
		Booking ID : ${book.bookingId}<br>
		Bus Schedule ID : ${book.busScheduleId}<br>
		Customer ID : ${book.customerId}<br>
		Status : ${book.status}<br><br>
	</c:forEach>
	
	<c:url value="UpdateBookingDetails.jsp" var="updateDetails">
		<c:param name="bookingId" value="${bookId}"/>
		<c:param name="busScheduleId" value="${busSchedId}"/>
		<c:param name="customerId" value="${cusId}"/>
		<c:param name="status" value="${status}"/>
	</c:url>
	
	<a href="${updateDetails}">
		<input type="button" value="Edit">
	</a><br>
	
	<c:url value="DeleteBookingDetails.jsp" var="deleteDetails">
		<c:param name="bookingId" value="${bookId}"/>
		<c:param name="busScheduleId" value="${busSchedId}"/>
		<c:param name="customerId" value="${cusId}"/>
		<c:param name="status" value="${status}"/>
	</c:url>
	<a href="${deleteDetails}">
		<input type="button" value="Delete">
	</a> 
	
</body>
</html>