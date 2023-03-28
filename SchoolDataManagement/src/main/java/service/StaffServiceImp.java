package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import reposirtyimplemantation.StaffRepoImp;
import repository.StaffRepository;
import schooldataclasses.Staff;
import util.AES;
import util.AppConstants;

public class StaffServiceImp  implements StaffService{

	  StaffRepository repository ;
	  {
		  repository =  new StaffRepoImp();
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
	public Staff staffLogin(String username, String password) {
		
		String enyPassword = AES.encrypt(password, AppConstants.SECRETKEY);
		
		Staff staffLogin = repository.staffLogin(username, enyPassword);
		
		staffLogin.setEmail(AES.decrypt(staffLogin.getEmail(), AppConstants.SECRETKEY));
		staffLogin.setContact(AES.decrypt(staffLogin.getContact(), AppConstants.SECRETKEY));
		staffLogin.setPassword(AES.decrypt(staffLogin.getPassword(), AppConstants.SECRETKEY));
		staffLogin.setSalary(AES.decrypt(staffLogin.getSalary(), AppConstants.SECRETKEY));
		return staffLogin;
	}

	@Override
	public String saveStaff(Staff staff) {
		
		staff.setEmail(AES.encrypt(staff.getEmail(), AppConstants.SECRETKEY));
		staff.setContact(AES.encrypt(staff.getContact(), AppConstants.SECRETKEY));
		staff.setPassword(AES.encrypt(staff.getPassword(), AppConstants.SECRETKEY));
		staff.setSalary(AES.encrypt(staff.getSalary(), AppConstants.SECRETKEY));
		
		return repository.saveStaff(staff);
	}

	@Override
	public Staff getStaffByd(int id) {
		
		Staff staffByd = repository.getStaffByd(id);
		
		staffByd.setEmail(AES.decrypt(staffByd.getEmail(), AppConstants.SECRETKEY));
		staffByd.setContact(AES.decrypt(staffByd.getContact(), AppConstants.SECRETKEY));
		staffByd.setPassword(AES.decrypt(staffByd.getPassword(), AppConstants.SECRETKEY));
		staffByd.setSalary(AES.decrypt(staffByd.getSalary(), AppConstants.SECRETKEY));
		
		return staffByd;
	}

	@Override
	public Staff updateStaffById(Staff staff) {
		staff.setEmail(AES.encrypt(staff.getEmail(), AppConstants.SECRETKEY));
		staff.setContact(AES.encrypt(staff.getContact(), AppConstants.SECRETKEY));
		staff.setPassword(AES.encrypt(staff.getPassword(), AppConstants.SECRETKEY));
		staff.setSalary(AES.encrypt(staff.getSalary(), AppConstants.SECRETKEY));
		Staff staffup = repository.updateStaffById(staff);
		staffup.setEmail(AES.decrypt(staff.getEmail(), AppConstants.SECRETKEY));
		staffup.setContact(AES.decrypt(staff.getContact(), AppConstants.SECRETKEY));
		staffup.setPassword(AES.decrypt(staff.getPassword(), AppConstants.SECRETKEY));
		staffup.setSalary(AES.decrypt(staff.getSalary(), AppConstants.SECRETKEY));
		return staffup;
	}


	@Override
	public List<Staff> getStaffByDesignation(String designation) {
		
		List<Staff> staffByDesignation = repository.getStaffByDesignation(designation);
		for(Staff staff :staffByDesignation) {
			staff.setEmail(AES.decrypt(staff.getEmail(), AppConstants.SECRETKEY));
			staff.setContact(AES.decrypt(staff.getContact(), AppConstants.SECRETKEY));
			staff.setPassword(AES.decrypt(staff.getPassword(), AppConstants.SECRETKEY));
			staff.setSalary(AES.decrypt(staff.getSalary(), AppConstants.SECRETKEY));
		}
		return staffByDesignation;
	}

	@Override
	public List<Staff> getStaffBySalary(int sal) {
		
		String decrypt = AES.encrypt(sal+"", AppConstants.SECRETKEY);
		
		List<Staff> staffBySalary = repository.getStaffBySalary(decrypt);
		for(Staff staff :staffBySalary) {
			staff.setEmail(AES.decrypt(staff.getEmail(), AppConstants.SECRETKEY));
			staff.setContact(AES.decrypt(staff.getContact(), AppConstants.SECRETKEY));
			staff.setPassword(AES.decrypt(staff.getPassword(), AppConstants.SECRETKEY));
			staff.setSalary(AES.decrypt(staff.getSalary(), AppConstants.SECRETKEY));
		}
	
		return staffBySalary;
	}

	@Override
	public List<Staff> getAllStaff() {
		
		List<Staff> allStaff = repository.getAllStaff();
		for(Staff staff :allStaff) {
			staff.setEmail(AES.decrypt(staff.getEmail(), AppConstants.SECRETKEY));
			staff.setContact(AES.decrypt(staff.getContact(), AppConstants.SECRETKEY));
			staff.setPassword(AES.decrypt(staff.getPassword(), AppConstants.SECRETKEY));
			staff.setSalary(AES.decrypt(staff.getSalary(), AppConstants.SECRETKEY));
		}
		return allStaff;
	}

	@Override
	public Staff deleteStaffById(int id) {
		
		return repository.deleteStaffById(id);
	}

}
