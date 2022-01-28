package com.techbee.registration;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface Dao  {
	
   
	
	void UpdateCustomer(String firstName, String UserName, String email) throws SQLException;
	void deleteCustomer(String firstName) throws SQLException;
	void addCustomer(Customer customer) throws SQLException;
	void createTable();
	void viewCustomers() throws SQLException;

}
