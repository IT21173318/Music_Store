package booking_models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BookingDBUtil {

	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet result = null;
	
//	Insert Data
	public static boolean insertBookingDetails(int bookingId, int busScheduleId, int customerId, int status) {
		
		boolean isSuccess = false;
		
		try {
			con = DBConnection.getConnection();
			stmt = con.createStatement();
			
			String sql = "insert into bookingdetails values('"+bookingId+"','"+busScheduleId+"', '"+customerId+"', '"+status+"')";
			
			int result = stmt.executeUpdate(sql);
			
			if(result > 0) {
				isSuccess = true;
			}else {
				isSuccess = false;
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return isSuccess;
	}
	
//	Display Data
	public static List<bookingDetails> displayDetails(int bookingId){
		
		ArrayList<bookingDetails> b1 = new ArrayList<>();
		
		try {
			con = DBConnection.getConnection();
			stmt = con.createStatement();
			
			String sql = "select * from bookingdetails where BookingID = '"+bookingId+"'";
			
			result = stmt.executeQuery(sql);
			
			while(result.next()) {
				int bId = result.getInt(1);
				int busScheduleId = result.getInt(2);
				int customerId = result.getInt(3);
				int status = result.getInt(4);
				
				bookingDetails bookDetails = new bookingDetails(bId, busScheduleId, customerId, status);
				b1.add(bookDetails);
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return b1;
	}
	
//	Update Details
	public static boolean updateDetails(int bookingId, int busScheduleId, int customerId, int status) {
		
		boolean isSuccess = false;
		
		try {
			con = DBConnection.getConnection();
			stmt = con.createStatement();
			String sql = "update bookingdetails set BusScheduleID = '"+busScheduleId+"', CustomerID = '"+customerId+"', Status='"+status+"' where BookingID = '"+bookingId+"'";
			
			int result = stmt.executeUpdate(sql);
			
			if(result>0) {
				isSuccess = true;
			}else {
				isSuccess = false;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return isSuccess;
	}
	
//	Delete Details
	public static boolean deleteDetails(int bookingId) {
		
		boolean isSuccess = false;
		
		try {
			con = DBConnection.getConnection();
			stmt = con.createStatement();
			String sql = "delete from bookingdetails where BookingID = '"+bookingId+"'";
			
			int result = stmt.executeUpdate(sql);
			
			if(result>0) {
				isSuccess = true;
			}else {
				isSuccess = false;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return isSuccess;
	}
}
