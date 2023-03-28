package repository;

import java.sql.Connection;
import java.util.List;

import schooldataclasses.Student;

public interface  StudentRepository {

	Connection getConnection();
	
    Student studentLogin(String username,String password);

    String saveStudent(Student student);
    
    Student getStudentById(int id);
    
    Student deleteStudentById(int id);
    
    Student updateStudentById(Student student);
    
    List<Student> getStudentByStandard(String standard);
    
    List<Student> getStudentByStandardAndSection(String standard,String section);
    
    List<Student> getStudentBetweenPercentage(String low, String high);
    
    List<Student> getAllStudents();
    
}
