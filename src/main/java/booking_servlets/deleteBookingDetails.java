package booking_servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import booking_models.BookingDBUtil;


public class deleteBookingDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String booking_id = request.getParameter("bookId");
		int bookingId = Integer.parseInt(booking_id);
		
		boolean isTrue = BookingDBUtil.deleteDetails(bookingId);
		
		if(isTrue == true) {
			RequestDispatcher dis = request.getRequestDispatcher("Book.jsp");
			dis.forward(request, response);
		}
		else {
			out.println("<script type='text/javascript'>");
			out.println("alert('Can not delete booking details!');");
			out.println("location ='DeleteBookingDetails.jsp'");
			out.println("</script>");
		}
	}

}
