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


public class insertBookingDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String bookingId = request.getParameter("bookingId");
		String busScheduleId = request.getParameter("busScheduleId");
		String customerId = request.getParameter("customerId");
		String status = request.getParameter("status");
		
		int booking_id = Integer.parseInt(bookingId);
		int busSchedule_id = Integer.parseInt(busScheduleId);
		int customer_id = Integer.parseInt(customerId);
		int Status = Integer.parseInt(status);
		
		boolean isTrue = BookingDBUtil.insertBookingDetails(booking_id, busSchedule_id, customer_id, Status);
		
		if(isTrue == true) {
			List<bookingDetails> booking = BookingDBUtil.displayDetails(booking_id);
			request.setAttribute("bookingDetails", booking);
			
			RequestDispatcher dis = request.getRequestDispatcher("BookingDetails.jsp");
			dis.forward(request, response);
		}else {
			out.println("<script type='text/javascript'>");
			out.println("alert('Enter different booking Id');");
			out.println("location ='Book.jsp'");
			out.println("</script>");
		}
	}

}
