package service;

import java.sql.Connection;
import java.util.List;

import schooldataclasses.Staff;

public interface StaffService {

	 Connection getConnection();
		
		Staff staffLogin(String username,String password);
		
		String saveStaff(Staff staff);
		
		Staff getStaffByd(int id);   
		
		 Staff updateStaffById(Staff staff);
		
		 Staff deleteStaffById(int id);
		
		List<Staff> getStaffByDesignation(String designation);
		  
		List<Staff> getStaffBySalary(int sal);
		    
	   List<Staff> getAllStaff();
}
