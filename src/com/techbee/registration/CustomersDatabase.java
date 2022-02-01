package com.techbee.registration;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CustomersDatabase implements Dao{
	
	
	Connection conn = null;
	
	
	
	// Creating the Customers table
	@Override
	public void createTable() {
		
		final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	    final String DB_URL = "jdbc:mysql://database-1.ck1e7ndgus2j.us-east-1.rds.amazonaws.com:3306/Registration";
	    final String USER = "admin";
	    final String PASS = "farir2005";
	    
	    //database-1.ck1e7ndgus2j.us-east-1.rds.amazonaws.com
	    
	    
	    
	    try {
	    	Class.forName("com.mysql.jdbc.Driver");
	    	System.out.println("Connecting to database...");
	    	
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
			
		      System.out.println("Creating table in given database...");
		      Statement stmt = conn.createStatement();

		      String sql = "CREATE TABLE Customers " + 
		                   "(phoneNumber INTEGER not NULL, " +
		                   " firstName VARCHAR(255), " + 
		                   " lastName VARCHAR(255), " + 
		                   " emailAdress VARCHAR(255), " +
		                   " UserName VARCHAR(255), " +
		                   " age INTEGER(30))"; 
		      

		      stmt.executeUpdate(sql);
		      System.out.println("Created table in the database");
			
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	// Add a customer.
	
	public void addCustomer(Customer customer) throws SQLException
	{
		String sql = "INSERT INTO Customers (phoneNumber, firstName, lastName, emailAdress, UserName, age) VALUES (?, ?, ?, ?, ?, ?)";
		
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setLong(1, customer.getPhoneNumber());
		statement.setString(2,customer.getFirstName() );
		statement.setString(3,customer.getLastName() );
		statement.setString(4,customer.getEmailAdress() );
		statement.setString(5,customer.getUserName() );
		statement.setLong(6,customer.getAge() );

		int rowsInserted = statement.executeUpdate();
		if (rowsInserted > 0) {
		System.out.println("A new user was inserted successfully!");
		}
	}
	// Read method to view all customer
	@Override
	public void viewCustomers() throws SQLException
	{
		String sql = "SELECT * FROM Customers";
		 
		Statement statement = conn.createStatement();
		ResultSet result = statement.executeQuery(sql);
		 
		int count = 0;
		
		while (result.next()){
		    String phoneNumber = result.getString(1);
		    String firstName = result.getString(2);
		    String lastName = result.getString(3);
		    String emailAdress = result.getString(4);
		    String UserName = result.getString(5);
		    String age = result.getString(6);

		 
		    String output = "User #%d: %s - %s - %s - %s";
		    System.out.println(String.format(output, ++count,phoneNumber, lastName, firstName, UserName, emailAdress, age));
		}
	
	}
	//Delete a customer.
	@Override
	public void deleteCustomer(String firstName) throws SQLException
	{
	String sql = "DELETE FROM Customers WHERE firstName=?";
	 
	PreparedStatement statement = conn.prepareStatement(sql);
	statement.setString(1, firstName);
	 
	int rowsDeleted = statement.executeUpdate();
	if (rowsDeleted > 0) 
	    System.out.println("A Customer was deleted successfully!");
	
	
	}
	
	//Update a customer
	public void UpdateCustomer(String firstName, String UserName, String email) throws SQLException
	{
		String sql = "UPDATE Customers SET UserName=?, emailAdress=? WHERE firstName=?";
		 
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, UserName);
		statement.setString(2, email);
		statement.setString(3, firstName);
		 
		int rowsUpdated = statement.executeUpdate();
		if (rowsUpdated > 0) {
		    System.out.println("Customer Data is updated successfully!");
		}
	
	
	}
}
