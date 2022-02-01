package com.techbee.registration;

import java.sql.SQLException;
import java.util.Scanner;

public class main {

	public static void main(String[] args) throws SQLException {
		
		Customer user1= new Customer("hass", "elh", 929334812 , "kjkjjjss@ll.com", "elhakjkjkjkjkjkkkk", 33);
		Customer user2= new Customer("lkl", "lo", 929334812 , "kjkjjjss@ll.com", "elhakjkjkjkjkjkkkk", 54);
		Customer user3= new Customer("uu", "kk", 552478523 , "kjkjjyss@ll.com", "elhakjkjkjkjkjkkkk", 20);
		Customer user4= new Customer("kk", "kj", 929300033 , "kjkjjjss@ll.com", "elhakjkjkjkjkjkkkk", 66);

		  
		Scanner in = new Scanner(System.in);
  
	 
		CustomersDatabase  controle = new  CustomersDatabase();
		
	controle.createTable();	
		 
	//Add Customers
		controle.addCustomer(user1);
		controle.addCustomer(user2);
		controle.addCustomer(user3);
		controle.addCustomer(user4);
	 
    // View All Customers
		controle.viewCustomers();

	 
	//Delete a Customer by First Name
	 System.out.print("please enter your  first name to delete your Data: ");
     String nameToDelete = in.nextLine();
     controle.deleteCustomer(nameToDelete);
	 
	//Update a Customer by First Name
	 System.out.print("please enter your first name to Update your Data: ");
     String nameToUpdate = in.nextLine();
     System.out.print("please enter your new UserName: ");
     String newUserName = in.nextLine();
     System.out.print("please enter your new Email Adress: ");
     String newemail = in.nextLine();
     
     
     controle.UpdateCustomer( nameToDelete, newUserName, newemail);
	 
	 //View the list after action taken
      controle.viewCustomers();

	}

}
