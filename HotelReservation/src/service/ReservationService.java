package service;

import java.util.ArrayList;  
import java.util.Collection; 
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.Customer;
import model.IRoom;
import model.Reservation;

public class ReservationService {
	
	
	static Map<String, IRoom> rooms = new HashMap<>();
	
	static Map<Reservation, Customer> reservation = new HashMap<>();
	
	
	public static void addRoom(IRoom room) {
		
		rooms.put(room.getRoomNumber(), room); 
		
	}
	
	public static IRoom getARoom(String roomId) {
		
		return rooms.get(roomId); 
	}
	
	public static Collection<IRoom> getAllRooms(){
		
		List<IRoom> allRooms = new ArrayList<>();
		
		for(IRoom room : rooms.values()) {
			allRooms.add(room);
		}
		
		return allRooms; 
		
	}
	
	public static void reserveARoom(Customer customer, IRoom room, Date checkIn, Date checkOut) {
				
		reservation.put(new Reservation(customer,room,checkIn, checkOut), customer);
		
	//	return reservation; 
		
	}
	
	public static Collection<IRoom> findRooms(Date checkInDate, Date checkOutDate){
		
		List<IRoom> availableRooms = new ArrayList<>();
		
		for(Reservation reservations : reservation.keySet()) {
			
			if(reservations.isRoomReserved(checkInDate, checkOutDate)) {
				availableRooms.add(reservations.getRoom());
			}
			
		}
		return availableRooms;
	}
	
	public Collection<Reservation> getCustomerReservation(Customer customer){
		
		return null;
	}
	
	public static void printAllReservation() {
		List<Reservation> reservations = new ArrayList<>();
		for(Reservation reserve : reservation.keySet()) {
			reservations.add(reserve);
		}
		
		System.out.println(reservations); 
		
	}

}
