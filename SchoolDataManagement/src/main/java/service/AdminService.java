package service;

import java.sql.Connection;

import schooldataclasses.Admin;

public interface AdminService {

Connection getConnection();
	
	String saveAdmin(Admin admin);
	
	Admin adminLogin(String username,String password);
}
