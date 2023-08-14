package booking_models;

public class bookingDetails {
	private int bookingId;
	private int busScheduleId;
	private int customerId;
	private int status;
	
	public bookingDetails(int bookingId, int busScheduleId, int customerId, int status) {
		this.bookingId = bookingId;
		this.busScheduleId = busScheduleId;
		this.customerId = customerId;
		this.status = status;
	}

	public int getBookingId() {
		return bookingId;
	}

	public int getBusScheduleId() {
		return busScheduleId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public int getStatus() {
		return status;
	}	

}
