package service;

import java.util.List;

import reposirtyimplemantation.TeacherRepoImp;
import repository.TeacherRepository;
import schooldataclasses.Teacher;
import util.AES;
import util.AppConstants;

public class TeacherServiceImp implements TeacherService{

	TeacherRepository repositoy ;
	{
		repositoy = new TeacherRepoImp();
	}
	@Override
	public Teacher teacherLogin(String username, String password) {
		
		return repositoy.teacherLogin(username, AES.encrypt(password,AppConstants.SECRETKEY));
	}

	@Override
	public String saveTeacher(Teacher teacher) {
		teacher.setEmail(AES.encrypt(teacher.getEmail(), AppConstants.SECRETKEY));
		teacher.setAddress(AES.encrypt(teacher.getAddress(), AppConstants.SECRETKEY));
		teacher.setContact(AES.encrypt(teacher.getContact(), AppConstants.SECRETKEY));
		teacher.setSalary(AES.encrypt(teacher.getSalary(), AppConstants.SECRETKEY));
		teacher.setPassword(AES.encrypt(teacher.getPassword(), AppConstants.SECRETKEY));
		return repositoy.saveTeacher(teacher);
	}

	@Override
	public Teacher getTeacherByd(int id) {
		Teacher teacherByd = repositoy.getTeacherByd(id);
		if(teacherByd== null) return null;
		teacherByd.setEmail(AES.decrypt(teacherByd.getEmail(), AppConstants.SECRETKEY));
		teacherByd.setAddress(AES.decrypt(teacherByd.getAddress(), AppConstants.SECRETKEY));
		teacherByd.setContact(AES.decrypt(teacherByd.getContact(), AppConstants.SECRETKEY));
		teacherByd.setSalary(AES.decrypt(teacherByd.getSalary(), AppConstants.SECRETKEY));
		teacherByd.setPassword(AES.decrypt(teacherByd.getPassword(), AppConstants.SECRETKEY));
		return teacherByd;
	}

	@Override
	public Teacher updateTeacherById(Teacher teacher) {
		
		teacher.setAddress(AES.encrypt(teacher.getAddress(), AppConstants.SECRETKEY));
		teacher.setContact(AES.encrypt(teacher.getContact(), AppConstants.SECRETKEY));
		teacher.setSalary(AES.encrypt(teacher.getSalary(), AppConstants.SECRETKEY));
		Teacher teacherByd = repositoy.updateTeacherById(teacher);
		if(teacherByd == null) return null; 
		teacherByd.setEmail(AES.decrypt(teacherByd.getEmail(), AppConstants.SECRETKEY));
		teacherByd.setAddress(AES.decrypt(teacherByd.getAddress(), AppConstants.SECRETKEY));
		teacherByd.setContact(AES.decrypt(teacherByd.getContact(), AppConstants.SECRETKEY));
		teacherByd.setSalary(AES.decrypt(teacherByd.getSalary(), AppConstants.SECRETKEY));
		teacherByd.setPassword(AES.decrypt(teacherByd.getPassword(), AppConstants.SECRETKEY));
		return teacherByd;
	}

	@Override
	public List<Teacher> getTeacherBySubject(String subject) {
	
		List<Teacher> teacherBySubject = repositoy.getTeacherBySubject(subject);
		if(teacherBySubject == null) return null; 
		for(Teacher teacher :teacherBySubject) {
			teacher.setEmail(AES.decrypt(teacher.getEmail(), AppConstants.SECRETKEY));
			teacher.setAddress(AES.decrypt(teacher.getAddress(), AppConstants.SECRETKEY));
			teacher.setContact(AES.decrypt(teacher.getContact(), AppConstants.SECRETKEY));
			teacher.setSalary(AES.decrypt(teacher.getSalary(), AppConstants.SECRETKEY));
			teacher.setPassword(AES.decrypt(teacher.getPassword(), AppConstants.SECRETKEY));
		}
		
		return teacherBySubject;
	}

	@Override
	public List<Teacher> getTeacherBySalary(int sal) {
		
		List<Teacher> teacherBySalary = repositoy.getTeacherBySalary(AES.encrypt(sal+"", AppConstants.SECRETKEY));
		if(teacherBySalary == null) return null; 
		for(Teacher teacher :teacherBySalary) {
			teacher.setEmail(AES.decrypt(teacher.getEmail(), AppConstants.SECRETKEY));
			teacher.setAddress(AES.decrypt(teacher.getAddress(), AppConstants.SECRETKEY));
			teacher.setContact(AES.decrypt(teacher.getContact(), AppConstants.SECRETKEY));
			teacher.setSalary(AES.decrypt(teacher.getSalary(), AppConstants.SECRETKEY));
			teacher.setPassword(AES.decrypt(teacher.getPassword(), AppConstants.SECRETKEY));
		}
		return teacherBySalary;
	}

	@Override
	public List<Teacher> getClassTeacher(String standard) {
		
		List<Teacher> classTeacher = repositoy.getClassTeacher(standard);
		if(classTeacher == null) return null; 
		for(Teacher teacher :classTeacher) {
			teacher.setEmail(AES.decrypt(teacher.getEmail(), AppConstants.SECRETKEY));
			teacher.setAddress(AES.decrypt(teacher.getAddress(), AppConstants.SECRETKEY));
			teacher.setContact(AES.decrypt(teacher.getContact(), AppConstants.SECRETKEY));
			teacher.setSalary(AES.decrypt(teacher.getSalary(), AppConstants.SECRETKEY));
			teacher.setPassword(AES.decrypt(teacher.getPassword(), AppConstants.SECRETKEY));
		}
		return classTeacher;
	}

	@Override
	public List<Teacher> getAllTeachers() {
	
		List<Teacher> allTeachers = repositoy.getAllTeachers();
		if(allTeachers == null) return null; 
		for(Teacher teacher :allTeachers) {
			teacher.setEmail(AES.decrypt(teacher.getEmail(), AppConstants.SECRETKEY));
			teacher.setAddress(AES.decrypt(teacher.getAddress(), AppConstants.SECRETKEY));
			teacher.setContact(AES.decrypt(teacher.getContact(), AppConstants.SECRETKEY));
			teacher.setSalary(AES.decrypt(teacher.getSalary(), AppConstants.SECRETKEY));
			teacher.setPassword(AES.decrypt(teacher.getPassword(), AppConstants.SECRETKEY));
		}
		return allTeachers;
	}

	@Override
	public Teacher deleteTeacherById(int id) {
		
		return repositoy.deleteTeacherById(id);
	}

	
}
