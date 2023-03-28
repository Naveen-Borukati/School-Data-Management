package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import reposirtyimplemantation.StudentRepoImp;
import repository.StudentRepository;
import schooldataclasses.Student;
import util.AES;
import util.AppConstants;

public class StudentServiceImp implements StudentService{

	StudentRepository repository;
	
	{
		 repository=new StudentRepoImp();
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
	public Student studentLogin(String username, String password) {
		
		String encPassword = AES.encrypt(password,AppConstants.SECRETKEY);

		Student studentLogin = repository.studentLogin(username, encPassword);
		if(studentLogin == null) return null;
		
		return studentLogin;
	}

	@Override
	public String saveStudent(Student student) {
	    String encEmail = AES.encrypt(student.getEmail(),AppConstants.SECRETKEY);
	    String encContact = AES.encrypt(student.getContact(),AppConstants.SECRETKEY);
	    String encAddress = AES.encrypt(student.getAddress(),AppConstants.SECRETKEY);
	    String encPassword = AES.encrypt(student.getPassword(),AppConstants.SECRETKEY);
	    student.setEmail(encEmail);
	    student.setAddress(encAddress);
	    student.setContact(encContact);
	    student.setPassword(encPassword);
	    
		return repository.saveStudent(student);
	}

	@Override
	public Student getStudentById(int id) {
		
		Student stu = repository.getStudentById(id);
		if(stu == null) return null; 
		stu.setEmail(AES.decrypt(stu.getEmail(), AppConstants.SECRETKEY));
		stu.setAddress(AES.decrypt(stu.getAddress(), AppConstants.SECRETKEY));
		stu.setPassword(AES.decrypt(stu.getPassword(), AppConstants.SECRETKEY));
		stu.setContact(AES.decrypt(stu.getContact(), AppConstants.SECRETKEY));
	
		return stu;
	}
	@Override
	public Student updateStudentById(Student student) {
		    String encEmail = AES.encrypt(student.getEmail(),AppConstants.SECRETKEY);
		    String encContact = AES.encrypt(student.getContact(),AppConstants.SECRETKEY);
		    String encAddress = AES.encrypt(student.getAddress(),AppConstants.SECRETKEY);
		    student.setEmail(encEmail);
		    student.setAddress(encAddress);
		    student.setContact(encContact);
		    Student stu = repository.updateStudentById(student);
		    if(stu==null) return null;
		    stu.setEmail(AES.decrypt(stu.getEmail(), AppConstants.SECRETKEY));
			stu.setAddress(AES.decrypt(stu.getAddress(), AppConstants.SECRETKEY));
			stu.setContact(AES.decrypt(stu.getContact(), AppConstants.SECRETKEY));
		return stu;
	}

	@Override
	public List<Student> getStudentByStandard(String standard) {
		
		List<Student> studentByStandard = repository.getStudentByStandard(standard);
		if(studentByStandard == null) return null; 
		for(Student stu : studentByStandard) {
			stu.setEmail(AES.decrypt(stu.getEmail(), AppConstants.SECRETKEY));
			stu.setAddress(AES.decrypt(stu.getAddress(), AppConstants.SECRETKEY));
			stu.setPassword(AES.decrypt(stu.getPassword(), AppConstants.SECRETKEY));
			stu.setContact(AES.decrypt(stu.getContact(), AppConstants.SECRETKEY));
		}
		
		return studentByStandard ;
	}

	@Override
	public List<Student> getStudentByStandardAndSection(String standard, String section) {
		
		List<Student> studentByStandardAndSection = repository.getStudentByStandardAndSection(standard, section);
		if(studentByStandardAndSection == null) return null; 
		for(Student stu : studentByStandardAndSection) {
			stu.setEmail(AES.decrypt(stu.getEmail(), AppConstants.SECRETKEY));
			stu.setAddress(AES.decrypt(stu.getAddress(), AppConstants.SECRETKEY));
			stu.setPassword(AES.decrypt(stu.getPassword(), AppConstants.SECRETKEY));
			stu.setContact(AES.decrypt(stu.getContact(), AppConstants.SECRETKEY));
		}
		
		return studentByStandardAndSection;
	}

	@Override
	public List<Student> getStudentBetweenPercentage(String low, String high) {
		
		List<Student> studentBetweenPercentage = repository.getStudentBetweenPercentage(low, high);
		if(studentBetweenPercentage == null) return null; 
		for(Student stu : studentBetweenPercentage) {
			stu.setEmail(AES.decrypt(stu.getEmail(), AppConstants.SECRETKEY));
			stu.setAddress(AES.decrypt(stu.getAddress(), AppConstants.SECRETKEY));
			stu.setPassword(AES.decrypt(stu.getPassword(), AppConstants.SECRETKEY));
			stu.setContact(AES.decrypt(stu.getContact(), AppConstants.SECRETKEY));
		}
		return studentBetweenPercentage;
	}

	@Override
	public List<Student> getAllStudents() {
		
		List<Student> allStudents = repository.getAllStudents();
		if(allStudents == null) return null; 
		for(Student stu : allStudents) {
			stu.setEmail(AES.decrypt(stu.getEmail(), AppConstants.SECRETKEY));
			stu.setAddress(AES.decrypt(stu.getAddress(), AppConstants.SECRETKEY));
			stu.setPassword(AES.decrypt(stu.getPassword(), AppConstants.SECRETKEY));
			stu.setContact(AES.decrypt(stu.getContact(), AppConstants.SECRETKEY));
		}
		return allStudents;
	}

	@Override
	public Student deleteStudentById(int id) {
	
		return repository.deleteStudentById(id);
	}

}

