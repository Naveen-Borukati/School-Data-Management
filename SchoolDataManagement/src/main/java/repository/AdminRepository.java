package repository;

import java.sql.Connection;

import schooldataclasses.Admin;

public interface AdminRepository {

	Connection getConnection();
	
	String saveAdmin(Admin admin);
	
	Admin adminLogin(String username,String password);
	
}
