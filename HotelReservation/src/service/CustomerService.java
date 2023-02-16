package service;

import java.util.ArrayList;  
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Customer;

public class CustomerService {
	
	static Customer customer;
	
	static Map<String, Customer> customers = new HashMap<>();
	
	
	public static void addCustomer(String email, String firstName, String lastName) {
		
		customers.put(email, new Customer(firstName, lastName, email));  
		 
	}

	
	public static Customer getCustomer(String customerEmail) {
		
		return	customers.get(customerEmail);
		
	}
	
	public static Collection<Customer> getAllCustomers(){
		
		List<Customer> Customers = new ArrayList<Customer>();
		
		for(Customer customer : customers.values()) {
			
			Customers.add(customer);
			
		}
		
		return Customers; 
	}
	
	
}
