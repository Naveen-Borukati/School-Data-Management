package service;

import java.util.List;

import schooldataclasses.Teacher;

public interface TeacherService {

  
	
	Teacher teacherLogin(String username,String password);
	
	String saveTeacher(Teacher teacher);
	
	Teacher getTeacherByd(int id);
	
	Teacher updateTeacherById(Teacher teacher);
	
	Teacher deleteTeacherById(int id);
	
	List<Teacher> getTeacherBySubject(String subject);
	  
	List<Teacher> getTeacherBySalary(int sal);
	    
   List<Teacher> getClassTeacher(String standard);
	    
   List<Teacher> getAllTeachers();
}
