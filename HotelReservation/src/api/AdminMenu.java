package api;

import java.util.ArrayList;  
import java.util.List;
import java.util.Scanner;
import model.IRoom;
import model.Room;
import model.RoomType;

public class AdminMenu {
	
	private static AdminMenu admin = new AdminMenu();
	
	private AdminMenu() {
		
	}
	
	public static AdminMenu getAdminMenu() {
		return admin;
	}
	
	Scanner scan = new Scanner(System.in);
	
	public static void display() {
		System.out.println("1. See all customers \n"
					+ "2. See all Rooms \n3. See all Reservation \n4. Add a Room \n5. MainMenu	");
		
		
		}
	
	public void choose() {
		
		 display();
		 
		 switch(Integer.parseInt(scan.nextLine())) {
		 
		 case 1:
		 	 System.out.println(AdminResources.getAllCustomers());
			 choose();
		 
		 case 2:
			 System.out.println(AdminResources.getAllRooms()); 
			 choose();
		 case 3:
		 	AdminResources.displayAllReservation();
		 	choose();
		 case 4:
			 List<IRoom> room = new ArrayList<>(); 
			 System.out.println("Please enter room number");
			 String roomNumber = scan.nextLine();
			 System.out.println("Please enter room price");
			 String roomPrice = scan.nextLine();
			 System.out.println("Please enter room enumeration");
			 RoomType enums = RoomType.valueOf(scan.nextLine().toUpperCase());   
			 room.add(new Room(roomNumber, Integer.parseInt(roomPrice), enums));
			 AdminResources.addRoom(room);  
			 choose();
			 
		 case 5:
			 MainMenu menu = MainMenu.getMenu();
			 menu.choose();
		}
		
		 scan.close();
		}
		
}


