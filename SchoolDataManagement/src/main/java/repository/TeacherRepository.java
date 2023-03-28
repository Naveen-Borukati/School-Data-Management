package repository;

import java.sql.Connection;
import java.util.List;

import schooldataclasses.Teacher;

public interface TeacherRepository {

	
	Connection getConnection();
	
	Teacher teacherLogin(String username,String password);
	
	String saveTeacher(Teacher teacher);
	
	Teacher getTeacherByd(int id);
	
	Teacher updateTeacherById(Teacher teacher);
	
	Teacher deleteTeacherById(int id);
	
	List<Teacher> getTeacherBySubject(String subject);
	  
	List<Teacher> getTeacherBySalary(String sal);
	    
   List<Teacher> getClassTeacher(String standard);
	    
   List<Teacher> getAllTeachers();
	    
}
