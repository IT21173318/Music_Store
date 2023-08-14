package booking_servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import booking_models.BookingDBUtil;
import booking_models.bookingDetails;


public class updateBookingDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String bookingId = request.getParameter("bookId");
		String busScheduleId = request.getParameter("bScheduleId");
		String customerId = request.getParameter("cusId");
		String status = request.getParameter("Status");
		
		int bookId = Integer.parseInt(bookingId);
		int busScheduleID = Integer.parseInt(busScheduleId);
		int customerID = Integer.parseInt(customerId);
		int Status = Integer.parseInt(status);
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		boolean isTrue = BookingDBUtil.updateDetails(bookId, busScheduleID, customerID, Status);
		
		if(isTrue == true) {
			List<bookingDetails> book = BookingDBUtil.displayDetails(bookId);
			request.setAttribute("bookingDetails", book);
			
			RequestDispatcher dis = request.getRequestDispatcher("BookingDetails.jsp");	
			dis.forward(request, response);
		}
		else {
			out.println("<script type='text/javascript'>");
			out.println("alert('Can't update booking Details !');");
			out.println("location ='UpdateBookingDetails.jsp'");
			out.println("</script>");
		}
	}

}