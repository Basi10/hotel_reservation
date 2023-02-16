package model;

import java.util.Date;
import java.util.Objects;

public class Reservation {
	
	private Customer customer;
	private IRoom room;
	private Date checkIn;
	private Date checkOut;
	
	public Reservation(Customer customer, IRoom room, Date checkIn, Date checkOut) {
		this.customer = customer;
		this.room = room;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	
	
	public Customer getCustomer() {
		return this.customer;
	}


	public IRoom getRoom() {
		return this.room;
	}


	public Date getCheckIn() {
		return this.checkIn;
	}


	public Date getCheckOut() {
		return this.checkOut;
	}
	
	
	public boolean isRoomReserved(Date checkInDate, Date checkOutDate) {
		
		if(checkInDate.before(checkOutDate) && checkOutDate.after(checkInDate)) {
			return true;
		}
		return false;
		
	}

	@Override
	public String toString() {
		return "Reservation [customer=" + customer + ", room=" + room + ", checkIn=" + checkIn + ", checkOut="
				+ checkOut + "]";
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Reservation))
			return false;
		Reservation other = (Reservation) obj;
		return Objects.equals(checkIn, other.checkIn) && Objects.equals(checkOut, other.checkOut)
				&& Objects.equals(customer, other.customer) && Objects.equals(room, other.room);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(checkIn, checkOut, customer, room);
	}
	
	
	
	
	

}
