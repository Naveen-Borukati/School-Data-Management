package reposirtyimplemantation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import repository.TeacherRepository;
import schooldataclasses.Teacher;

public class TeacherRepoImp implements TeacherRepository{

	@Override
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/schooldatamanagement";
			String user="root";
			String pass="root";
			return DriverManager.getConnection(url,user,pass);
		}catch(ClassNotFoundException|SQLException e) {
		    e.printStackTrace();
		}
		return null;
	}
	@Override
	public Teacher teacherLogin(String username, String password) {
		Connection con = getConnection();
		Teacher a=null;
		try {
			PreparedStatement pre = con.prepareStatement("select * from teacher where uname=? and pass=?");
			pre.setString(1, username);
			pre.setString(2, password);
			ResultSet exe = pre.executeQuery();
			if(!exe.next()) return null;
			a = new Teacher();
			a.setId(exe.getString(1));
		    con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}

	@Override
	public String saveTeacher(Teacher teacher) {
		Connection con = getConnection();
		int exe =0;
		try {
			PreparedStatement pre = con.prepareStatement("insert into `teacher` (name, email, cont, sub, class_teacher, sal, `add`, `pass`, `uname`)values (?,?,?,?,?,?,?,?,?)");
		  //id, name, email, cont, sub, class_teacher, sal, add, pass, uname
			
			pre.setString(1, teacher.getName());
		    pre.setString(2, teacher.getEmail());
		    pre.setString(3, teacher.getContact());
		    pre.setString(4, teacher.getSubject());
		    pre.setString(5, teacher.getClassteacher());
		    pre.setString(6, teacher.getSalary());
		    pre.setString(7, teacher.getAddress());
		    pre.setString(8, teacher.getPassword());
		    pre.setString(9, teacher.getUsername());
		   
		    exe = pre.executeUpdate();
		    con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return exe+"";
	}

	@Override
	public Teacher getTeacherByd(int id) {
     
		Teacher tech = new Teacher();
		
		Connection con = getConnection();
		try {
			PreparedStatement pre = con.prepareStatement("select * from teacher where id=?");
			pre.setInt(1, id);
			ResultSet res = pre.executeQuery();
			if(res.next()) {
				 //id, name, email, cont, sub, class_teacher, sal, add, pass, uname
				tech.setId(res.getInt(1)+"");
				tech.setName(res.getString(2));
				tech.setEmail(res.getString(3));
				tech.setContact(res.getString(4));
				tech.setSubject(res.getString(5));
				tech.setClassteacher(res.getString(6));
				tech.setSalary(res.getString(7));
				tech.setAddress(res.getString(8));
				tech.setPassword(res.getString(9));
				tech.setUsername(res.getString(10));
			}
			else {
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tech;
	}

	@Override
	public Teacher deleteTeacherById(int id) {
       Teacher tech = new Teacher();
		
		Connection con = getConnection();
		try {
			PreparedStatement pre = con.prepareStatement("select * from teacher where id=?");
			pre.setInt(1, id);
			ResultSet res = pre.executeQuery();
			if(res.next()) {
				 //id, name, email, cont, sub, class_teacher, sal, add, pass, uname
				tech.setId(res.getInt(1)+"I");
				tech.setName(res.getString(2));
				tech.setEmail(res.getString(3));
				tech.setContact(res.getString(4));
				tech.setSubject(res.getString(5));
				tech.setClassteacher(res.getString(6));
				tech.setSalary(res.getString(7));
				tech.setAddress(res.getString(8));
				tech.setPassword(res.getString(9));
				tech.setUsername(res.getString(10));
				PreparedStatement pree = con.prepareStatement("delete from teacher where id=?");
				pree.setInt(1, id);
			    pree.executeUpdate();
			}
			else {
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tech;
	}

	@Override
	public List<Teacher> getTeacherBySubject(String subject) {
		
		List<Teacher> list = new ArrayList<>();
		int count=0;
		Connection conn = getConnection();
		
		try {
			PreparedStatement pre = conn.prepareStatement("select * from teacher where sub=?");
			pre.setString(1, subject);
			ResultSet res = pre.executeQuery();
			while(res.next()) {
				//id, name, email, cont, sub, class_teacher, sal, add, pass, uname			
				Teacher tech = new Teacher();
				tech.setId(res.getInt(1)+"");
				tech.setName(res.getString(2));
				tech.setEmail(res.getString(3));
				tech.setContact(res.getString(4));
				tech.setSubject(res.getString(5));
				tech.setClassteacher(res.getString(6));
				tech.setSalary(res.getString(7));
				tech.setAddress(res.getString(8));
				tech.setPassword(res.getString(9));
				tech.setUsername(res.getString(10));
				list.add(tech);
				count++;
			}
			if(count==0)return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Teacher> getTeacherBySalary(String sal) {
		List<Teacher> list = new ArrayList<>();
		int count=0;
		Connection conn = getConnection();
		
		try {
			PreparedStatement pre = conn.prepareStatement("select * from teacher where sal=?");
			pre.setString(1, sal);
			ResultSet res = pre.executeQuery();
			while(res.next()) {
				//id, name, email, cont, sub, class_teacher, sal, add, pass, uname			
				Teacher tech = new Teacher();
				tech.setId(res.getInt(1)+"");
				tech.setName(res.getString(2));
				tech.setEmail(res.getString(3));
				tech.setContact(res.getString(4));
				tech.setSubject(res.getString(5));
				tech.setClassteacher(res.getString(6));
				tech.setSalary(res.getString(7));
				tech.setAddress(res.getString(8));
				tech.setPassword(res.getString(9));
				tech.setUsername(res.getString(10));
				list.add(tech);
				count++;
			}
			if(count==0)return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return list;
	}

	@Override
	public List<Teacher> getClassTeacher(String standard) {
		List<Teacher> list = new ArrayList<>();
		int count=0;
		Connection conn = getConnection();
		
		try {
			PreparedStatement pre = conn.prepareStatement("select * from teacher where class_teacher=?");
			pre.setString(1, standard);
			ResultSet res = pre.executeQuery();
			while(res.next()) {
				//id, name, email, cont, sub, class_teacher, sal, add, pass, uname			
				Teacher tech = new Teacher();
				tech.setId(res.getInt(1)+"");
				tech.setName(res.getString(2));
				tech.setEmail(res.getString(3));
				tech.setContact(res.getString(4));
				tech.setSubject(res.getString(5));
				tech.setClassteacher(res.getString(6));
				tech.setSalary(res.getString(7));
				tech.setAddress(res.getString(8));
				tech.setPassword(res.getString(9));
				tech.setUsername(res.getString(10));
				list.add(tech);
				count++;
			}
			if(count==0)return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Teacher> getAllTeachers() {
		List<Teacher> list = new ArrayList<>();
		int count=0;
		Connection conn = getConnection();
		
		try {
			PreparedStatement pre = conn.prepareStatement("select * from teacher");
		
			ResultSet res = pre.executeQuery();
			while(res.next()) {
				//id, name, email, cont, sub, class_teacher, sal, add, pass, uname			
				Teacher tech = new Teacher();
				tech.setId(res.getInt(1)+"");
				tech.setName(res.getString(2));
				tech.setEmail(res.getString(3));
				tech.setContact(res.getString(4));
				tech.setSubject(res.getString(5));
				tech.setClassteacher(res.getString(6));
				tech.setSalary(res.getString(7));
				tech.setAddress(res.getString(8));
				tech.setPassword(res.getString(9));
				tech.setUsername(res.getString(10));
				list.add(tech);
				count++;
			}
			if(count==0)return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Teacher updateTeacherById(Teacher teacher) {
		
		Teacher tech = new Teacher();
		Connection conn = getConnection();
		try {
            PreparedStatement pre = conn.prepareStatement("update teacher set name=?,cont=?,class_teacher=?,`add`=?,sal=? where id=?");
			pre.setString(1, teacher.getName());
			pre.setString(2, teacher.getContact());
			pre.setString(3, teacher.getClassteacher());
			pre.setString(4, teacher.getAddress());
			pre.setString(5, teacher.getSalary());
			pre.setInt(6, Integer.parseInt(teacher.getId()));
			int executeUpdate = pre.executeUpdate();
			if(executeUpdate==0) {
				return null;
			}
			PreparedStatement pret = conn.prepareStatement("select * from teacher where id=?");
			pret.setInt(1, Integer.parseInt(teacher.getId()));
			ResultSet res = pret.executeQuery();
			if(res.next()) {
				 //id, name, email, cont, sub, class_teacher, sal, add, pass, uname
				tech.setId(res.getInt(1)+"");
				tech.setName(res.getString(2));
				tech.setEmail(res.getString(3));
				tech.setContact(res.getString(4));
				tech.setSubject(res.getString(5));
				tech.setClassteacher(res.getString(6));
				tech.setSalary(res.getString(7));
				tech.setAddress(res.getString(8));
				tech.setPassword(res.getString(9));
				tech.setUsername(res.getString(10));
			}
			else {
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return tech;
	}

}
