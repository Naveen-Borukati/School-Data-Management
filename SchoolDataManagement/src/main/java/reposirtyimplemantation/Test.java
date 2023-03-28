package reposirtyimplemantation;

import schooldataclasses.Student;
import schooldataclasses.Teacher;
import service.StudentServiceImp;
import service.TeacherServiceImp;

public class Test {

   public static void main(String[] args) {
	   //id, name, email, stad, sec, per, gender, cont, remarks, add, pass, uname
	  Student student = new Student();
	  student.setId("1");
	  student.setName("Naveen");
	  student.setEmail("naveen@gmail.com");
	
	  student.setSection("A");
	  student.setPercentage("92");
	
	  student.setContact("73336632283");
	  student.setRemarks("good student");
	  student.setAddress("kavali");
	
	   
	  StudentServiceImp serviceImp = new StudentServiceImp();
	  Student byId = serviceImp.studentLogin("naveen", "kondamma");
	  System.out.println(byId.getName());
   }  
}
