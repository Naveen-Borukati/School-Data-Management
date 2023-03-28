package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import reposirtyimplemantation.AdminRepoImp;
import repository.AdminRepository;
import schooldataclasses.Admin;
import util.AES;
import util.AppConstants;

public class AdminServiceImp implements AdminService {

		AdminRepository repository;
		{
			repository= new AdminRepoImp();
		}
	
	@Override
	public Connection getConnection() {
		try {
			Class.forName(AppConstants.DRIVERNAME);
			String url=AppConstants.DB_URL;
			String user=AppConstants.DB_USERNAME;
			String pass=AppConstants.DB_PASSWORD;
			return DriverManager.getConnection(url,user,pass);
			
		}catch(ClassNotFoundException|SQLException e) {
		    e.printStackTrace();
		}
		return null;
	}

	@Override
	public String saveAdmin(Admin admin) {
		
		admin.setPassword(AES.encrypt(admin.getPassword(), AppConstants.SECRETKEY));
		
		return repository.saveAdmin(admin);
	}

	@Override
	public Admin adminLogin(String username, String password) {
		
		Admin adminLogin = repository.adminLogin(username,  AES.encrypt(password,AppConstants.SECRETKEY));
		
		adminLogin.setPassword(AES.decrypt(adminLogin.getPassword(),AppConstants.SECRETKEY));
		
		return adminLogin;
	}

}
