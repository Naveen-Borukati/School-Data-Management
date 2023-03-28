package reposirtyimplemantation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import repository.StudentRepository;

import schooldataclasses.Student;
import util.AppConstants;

public class StudentRepoImp implements StudentRepository{

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
		Connection con = getConnection();
		Student a = new Student();
		try {
			PreparedStatement pre = con.prepareStatement("select * from student where uname=? and pass=?");
			pre.setString(1, username);
			pre.setString(2, password);
			ResultSet exe = pre.executeQuery();
			if(exe.next()) {
			
				a.setId(exe.getString(1));
				return a;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String saveStudent(Student stu) {
		Connection con = getConnection();
		int exe =0;
		try {
			PreparedStatement pre = con.prepareStatement("insert into `student`(name, email, stad, sec, per, gender, cont, `remarks`, `add`, `pass`,`uname`) values (?,?,?,?,?,?,?,?,?,?,?)");
	
			pre.setString(1, stu.getName());
		    pre.setString(2, stu.getEmail());
		    pre.setString(3, stu.getStandard());
		    pre.setString(4, stu.getSection());
		    pre.setString(5, stu.getPercentage());
		    pre.setString(6, stu.getGender());
		    pre.setString(7, stu.getContact());
		    pre.setString(8, stu.getRemarks());
		    pre.setString(9, stu.getAddress());
		    pre.setString(10, stu.getPassword());
		    pre.setString(11, stu.getUsername());
		    exe = pre.executeUpdate();
		    con.close();
		} catch (SQLException e) {
			return exe+"";
		}
		
		return exe+"";
	}

	@Override
	public Student getStudentById(int id) {
		
		Student stu = new Student();
		
		Connection con = getConnection();
		try {
			PreparedStatement pre = con.prepareStatement("select * from student where id=?");
			pre.setInt(1, id);
			ResultSet res = pre.executeQuery();
			if(res.next()) {
				 //name, email, stad, sec, per, gender, cont, remarks, add, pass, uname
				stu.setId(res.getInt(1)+"");
				stu.setName(res.getString(2));
				stu.setEmail(res.getString(3));
				stu.setStandard(res.getString(4));
				stu.setSection(res.getString(5));
				stu.setPercentage(res.getString(6));
				stu.setGender(res.getString(7));
				stu.setContact(res.getString(8));
				stu.setRemarks(res.getString(9));
				stu.setAddress(res.getString(10));
				stu.setPassword(res.getString(11));
				stu.setUsername(res.getString(12));
				
			}
			else {
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stu;
	}

	@Override
	public Student deleteStudentById(int id) {
	Student stu = new Student();
		
		Connection con = getConnection();
		try {
			PreparedStatement pre = con.prepareStatement("select * from student where id=?");
			pre.setInt(1, id);
			ResultSet res = pre.executeQuery();
			if(res.next()) {
				 //name, email, stad, sec, per, gender, cont, remarks, add, pass, uname
				stu.setId(res.getInt(1)+"I");
				stu.setName(res.getString(2));
				stu.setEmail(res.getString(3));
				stu.setStandard(res.getString(4));
				stu.setSection(res.getString(5));
				stu.setPercentage(res.getString(6));
				stu.setGender(res.getString(7));
				stu.setContact(res.getString(8));
				stu.setRemarks(res.getString(9));
				stu.setAddress(res.getString(10));
				stu.setPassword(res.getString(11));
				stu.setUsername(res.getString(12));
				PreparedStatement pre1 = con.prepareStatement("delete from student where id =?");
				pre1.setInt(1, id);
				pre1.executeUpdate();
				
			}
			else {
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stu;
	}

	@Override
	public Student updateStudentById(Student stu) {
	Student stud = new Student();
	ResultSet res =null;
		Connection con = getConnection();
		try {
			PreparedStatement pre = con.prepareStatement("update `student` set name=?,email=?,sec=?,per=?,cont=?,remarks=?,`add`=? where id=?");
			     //name, email, stad, sec, per, gender, cont, remarks, add, pass, uname
				pre.setString(1, stu.getName());
			    pre.setString(2, stu.getEmail());
			    pre.setString(3, stu.getSection());
			    pre.setString(4, stu.getPercentage());
			    pre.setString(5, stu.getContact());
			    pre.setString(6, stu.getRemarks());
			    pre.setString(7, stu.getAddress());
			    pre.setInt(8,Integer.parseInt(stu.getId()));
			    
			int up = pre.executeUpdate();
			if(up==1) {
				PreparedStatement pree = con.prepareStatement("select * from student where id=?");
				pree.setInt(1, Integer.parseInt(stu.getId()));
				res = pree.executeQuery();
			}
			else {
				return null;
			}
			if(res.next()) {
				 //name, email, stad, sec, per, gender, cont, remarks, add, pass, uname
				stud.setId(res.getInt(1)+"");
				stud.setName(res.getString(2));
				stud.setEmail(res.getString(3));
				stud.setStandard(res.getString(4));
				stud.setSection(res.getString(5));
				stud.setPercentage(res.getString(6));
				stud.setGender(res.getString(7));
				stud.setContact(res.getString(8));
				stud.setRemarks(res.getString(9));
				stud.setAddress(res.getString(10));
				stud.setPassword(res.getString(11));
				stud.setUsername(res.getString(12));
			}
			else {
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stud;
	}

	@Override
	public List<Student> getStudentByStandard(String standard) {
		
		List<Student> list = new ArrayList<>();
		Connection con = getConnection();
		int check=0;
		try {
			PreparedStatement pre = con.prepareStatement("select * from student where stad=?");
			pre.setString(1, standard);
			ResultSet res = pre.executeQuery();
			while(res.next()) {
				check++;
				 //name, email, stad, sec, per, gender, cont, remarks, add, pass, uname
				Student stu = new Student();
				stu.setId(res.getInt(1)+"I");
				stu.setName(res.getString(2));
				stu.setEmail(res.getString(3));
				stu.setStandard(res.getString(4));
				stu.setSection(res.getString(5));
				stu.setPercentage(res.getString(6));
				stu.setGender(res.getString(7));
				stu.setContact(res.getString(8));
				stu.setRemarks(res.getString(9));
				stu.setAddress(res.getString(10));
				stu.setPassword(res.getString(11));
				stu.setUsername(res.getString(12));
				list.add(stu);
				
			}
			if(check==0) {
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Student> getStudentByStandardAndSection(String standard, String section) {
		List<Student> list = new ArrayList<>();
		Connection con = getConnection();
		int check=0;
		try {
			PreparedStatement pre = con.prepareStatement("select * from student where stad=? and sec=?");
			pre.setString(1, standard);
			pre.setString(2, section);
			ResultSet res = pre.executeQuery();
			while(res.next()) {
				check++;
				 //name, email, stad, sec, per, gender, cont, remarks, add, pass, uname
				Student stu = new Student();
				stu.setId(res.getInt(1)+"I");
				stu.setName(res.getString(2));
				stu.setEmail(res.getString(3));
				stu.setStandard(res.getString(4));
				stu.setSection(res.getString(5));
				stu.setPercentage(res.getString(6));
				stu.setGender(res.getString(7));
				stu.setContact(res.getString(8));
				stu.setRemarks(res.getString(9));
				stu.setAddress(res.getString(10));
				stu.setPassword(res.getString(11));
				stu.setUsername(res.getString(12));
				list.add(stu);
			}
			if(check==0) {
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Student> getStudentBetweenPercentage(String low, String high) {
		List<Student> list = new ArrayList<>();
		Connection con = getConnection();
		int check=0;
		try {
			PreparedStatement pre = con.prepareStatement("select * from student where per between ? and ?");
			pre.setString(1, low);
			pre.setString(2, high);
			ResultSet res = pre.executeQuery();
			while(res.next()) {
				check++;
				 //name, email, stad, sec, per, gender, cont, remarks, add, pass, uname
				Student stu = new Student();
				stu.setId(res.getInt(1)+"I");
				stu.setName(res.getString(2));
				stu.setEmail(res.getString(3));
				stu.setStandard(res.getString(4));
				stu.setSection(res.getString(5));
				stu.setPercentage(res.getString(6));
				stu.setGender(res.getString(7));
				stu.setContact(res.getString(8));
				stu.setRemarks(res.getString(9));
				stu.setAddress(res.getString(10));
				stu.setPassword(res.getString(11));
				stu.setUsername(res.getString(12));
				list.add(stu);
			}
			if(check==0) {
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Student> getAllStudents() {
		List<Student> list = new ArrayList<>();
		Connection con = getConnection();
		int check=0;
		try {
			PreparedStatement pre = con.prepareStatement("select * from student");
			
			ResultSet res = pre.executeQuery();
			while(res.next()) {
				check++;
				 //name, email, stad, sec, per, gender, cont, remarks, add, pass, uname
				Student stu = new Student();
				stu.setId(res.getInt(1)+"");
				stu.setName(res.getString(2));
				stu.setEmail(res.getString(3));
				stu.setStandard(res.getString(4));
				stu.setSection(res.getString(5));
				stu.setPercentage(res.getString(6));
				stu.setGender(res.getString(7));
				stu.setContact(res.getString(8));
				stu.setRemarks(res.getString(9));
				stu.setAddress(res.getString(10));
				stu.setPassword(res.getString(11));
				stu.setUsername(res.getString(12));
				list.add(stu);
			}
			if(check==0) {
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
