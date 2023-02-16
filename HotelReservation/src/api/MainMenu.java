package api;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public final class MainMenu {
	
	AdminMenu admin = AdminMenu.getAdminMenu();
	
	private static MainMenu menu = new MainMenu();
		
	private MainMenu() {
	}
	
	public static MainMenu getMenu() {
		return menu;
	}
	
	Scanner scan = new Scanner(System.in);
		
	public static void display() {
		System.out.println("1. Find and reserve a room \n"
				+ "2. See My reservation \n3. Create an account \n4. Admin \n5. Exit");
		}
	 
	
	public void choose() {
	 display();
	 
	 switch(Integer.parseInt(scan.nextLine())) {
	 
	 case 1:
		 findAndReserveARoom();
	 
	 case 2:
		 break;
	
	 case 3:
		 createACustomer();
	 case 4:
		 admin.choose();
		 
	 case 5:
	}
	
	 scan.close();
	}
	
	
	public void findAndReserveARoom() {
		
		System.out.println("Please Input Check In Date MM-dd-yyyy");
		Date checkInDate = getDate();
		
		System.out.println("Please Input Check Out Date MM-dd-yyyy");
		Date checkOutDate = getDate();
		
		System.out.println(HotelResource.findARoom(checkInDate, checkOutDate));
		
		System.out.println("Would you like to book a room with us?");
		String input = scan.nextLine().toLowerCase();
		
		
		if(input.equals("y")) {
			System.out.println("Do you have an account with us?");
			String in = scan.nextLine().toLowerCase();
			if(in.equals("y")) {
				
				System.out.println("Please input your email adress");
				String email = scan.nextLine(); 
				
				if(HotelResource.getCustomer(email) == null) {
					System.out.println("Sorry the email you have entered does not have an account with us");
				}else {
					
					
					System.out.println("Which room would you like to book?");
					String roomNumber = scan.nextLine().toLowerCase();
					
					if(HotelResource.getRoom(roomNumber) == null) {
						
					}else {
						HotelResource.bookARoom(email, HotelResource.getRoom(roomNumber), checkInDate, checkOutDate);
						choose();
					}
					
				}
					
				}else {
					createACustomer();
			}
		}else {
			choose();
		}
		
		
			
		}
		
		
	public void createACustomer() {
		 System.out.println("Please enter your first name");
		 String firstName = scan.nextLine();
		 System.out.println("Please enter your last name");
		 String lastName = scan.nextLine();
		 System.out.println("Please enter your email");
		 String email = scan.nextLine();
		 HotelResource.createACustomer(email, firstName, lastName);
		 choose();
		}
	
	public Date getDate() {
		Date today = new Date();
		String pattern = "MM-dd-yyyy";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);		
		Date checkInDate = null; 
		try {
			checkInDate = simpleDateFormat.parse(scan.nextLine());
			if((checkInDate.before(today))) {
				throw(new IllegalArgumentException());
			}
		}catch(IllegalArgumentException | ParseException e) {
			System.out.println("Sorry your input date is invalid, please try again.");
			findAndReserveARoom();
		}
		return checkInDate;
	}

	
}	