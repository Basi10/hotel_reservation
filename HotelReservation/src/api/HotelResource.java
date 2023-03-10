package api;

import java.util.Collection;   
import java.util.Date;
import model.Customer;
import model.IRoom;
import model.Reservation;
import service.CustomerService;
import service.ReservationService;

public class HotelResource {
	
	public static Customer getCustomer(String email) {
		
		return CustomerService.getCustomer(email);
	}

	public static void createACustomer(String email, String firstName, String lastName) {
		
		CustomerService.addCustomer(email, firstName, lastName);
	
	}
	
	public static IRoom getRoom(String roomNumber) {
		
		return ReservationService.getARoom(roomNumber);
	}
	
	public static Reservation bookARoom(String customerEmail, IRoom room, Date checkIn, Date checkOut) {
		
		Reservation reservation = new Reservation(getCustomer(customerEmail), room, checkIn, checkOut);
		
		return reservation; 
	}
	
	public Collection<Reservation> getCustomerReservations(String customerEmail){
		
		return null;
	}
	
	public static Collection<IRoom> findARoom(Date checkIn, Date checkOut){
		
		return ReservationService.findRooms(checkIn, checkOut);  
	}
	
	
	
}
