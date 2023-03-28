package util;

import schooldataclasses.Teacher;
import service.TeacherServiceImp;

public class Test {

	public static void main(String[] args) {
		//id, name, email, cont, sub, class_teacher, sal, add, pass, uname
		Teacher teacher = new Teacher();
		teacher.setId("1");
		teacher.setName("enkey");
		teacher.setContact("80436456232");
		teacher.setClassteacher("10");
		teacher.setSalary("50000");
		teacher.setAddress("Bangalore");
		
		TeacherServiceImp serviceImp = new TeacherServiceImp();
		Teacher updateTeacherById = serviceImp.updateTeacherById(teacher);
		if(updateTeacherById ==null){
			System.out.println("no");
		}else {
			System.out.println("yes");
		}
	}
}
