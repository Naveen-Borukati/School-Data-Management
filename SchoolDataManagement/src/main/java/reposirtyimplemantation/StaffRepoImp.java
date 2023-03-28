package reposirtyimplemantation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import repository.StaffRepository;
import schooldataclasses.Staff;

public class StaffRepoImp implements StaffRepository {

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
	public Staff staffLogin(String username, String password) {
		Connection con = getConnection();
		Staff staff = new Staff();
		try {
			PreparedStatement pre = con.prepareStatement("select * from staff where uname=? and pass=?");
			pre.setString(1, username);
			pre.setString(2, password);
			ResultSet res = pre.executeQuery();
			if(!res.next()) return null;
			staff.setId(res.getInt(1)+"");
			staff.setName(res.getString(2));
			staff.setContact(res.getString(3));
			staff.setEmail(res.getString(4));
			staff.setSalary(res.getString(5));
			staff.setDesignation(res.getString(6));
			staff.setUsername(res.getString(7));
			staff.setPassword(res.getString(8));
		    con.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return staff;
	}

	@Override
	public String saveStaff(Staff staff) {
		int result=0;
		Connection conn = getConnection();
		try {
			//id, name, cont, email, sal, des, uname, pass
			PreparedStatement pre = conn.prepareStatement("insert into staff values(?,?,?,?,?,?,?,?)");
			pre.setInt(1, Integer.parseInt(staff.getId()));
			pre.setString(2, staff.getName());
			pre.setString(3, staff.getContact());
			pre.setString(4, staff.getEmail());
			pre.setString(5, staff.getSalary());
			pre.setString(6, staff.getDesignation());
			pre.setString(7, staff.getUsername());
			pre.setString(8, staff.getPassword());
		    result = pre.executeUpdate();
		} catch (SQLException e) {
			return "0";
		}
		return result+"";
	}

	@Override
	public Staff getStaffByd(int id) {
     Staff staff = new Staff();
		
		Connection con = getConnection();
		try {
			PreparedStatement pre = con.prepareStatement("select * from staff where id=?");
			pre.setInt(1, id);
			ResultSet res = pre.executeQuery();
			if(res.next()) {
				//id, name, cont, email, sal, des, uname, pass
				staff.setId(res.getInt(1)+"");
				staff.setName(res.getString(2));
				staff.setContact(res.getString(3));
				staff.setEmail(res.getString(4));
				staff.setSalary(res.getString(5));
				staff.setDesignation(res.getString(6));
				staff.setUsername(res.getString(7));
				staff.setPassword(res.getString(8));
			}
			else {
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return staff;
	}



	@Override
	public Staff deleteStaffById(int id) {
		Staff staff = new Staff();
			
			Connection con = getConnection();
			try {
				PreparedStatement pre = con.prepareStatement("select * from staff where id=?");
				pre.setInt(1, id);
				ResultSet res = pre.executeQuery();
				if(res.next()) {
					 //id, name, email, cont, sub, class_teacher, sal, add, pass, uname
					staff.setId(res.getInt(1)+"");
					staff.setName(res.getString(2));
					staff.setContact(res.getString(3));
					staff.setEmail(res.getString(4));
					staff.setSalary(res.getString(5));
					staff.setDesignation(res.getString(6));
					staff.setUsername(res.getString(7));
					staff.setPassword(res.getString(8));
					PreparedStatement pree = con.prepareStatement("delete from staff where id=?");
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
			return staff;
	}

	@Override
	public List<Staff> getStaffByDesignation(String designation) {
		List<Staff> list = new ArrayList<>();
		int count=0;
		Connection conn = getConnection();
		
		try {
			PreparedStatement pre = conn.prepareStatement("select * from staff where des=?");
		    pre.setString(1, designation);
			ResultSet res = pre.executeQuery();
			while(res.next()) {
				//id, name, email, cont, sub, class_teacher, sal, add, pass, uname			
				 Staff staff = new Staff();
				 staff.setId(res.getInt(1)+"");
					staff.setName(res.getString(2));
					staff.setContact(res.getString(3));
					staff.setEmail(res.getString(4));
					staff.setSalary(res.getString(5));
					staff.setDesignation(res.getString(6));
					staff.setUsername(res.getString(7));
					staff.setPassword(res.getString(8));
				list.add(staff);
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
	public List<Staff> getStaffBySalary(String salary) {
		List<Staff> list = new ArrayList<>();
		int count=0;
		Connection conn = getConnection();
		
		try {
			PreparedStatement pre = conn.prepareStatement("select * from staff where sal=?");
		     pre.setString(1, salary);
			ResultSet res = pre.executeQuery();
			while(res.next()) {
				//id, name, email, cont, sub, class_teacher, sal, add, pass, uname			
				 Staff staff = new Staff();
				 staff.setId(res.getInt(1)+"");
					staff.setName(res.getString(2));
					staff.setContact(res.getString(3));
					staff.setEmail(res.getString(4));
					staff.setSalary(res.getString(5));
					staff.setDesignation(res.getString(6));
					staff.setUsername(res.getString(7));
					staff.setPassword(res.getString(8));
				list.add(staff);
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
	public List<Staff> getAllStaff() {
		List<Staff> list = new ArrayList<>();
		int count=0;
		Connection conn = getConnection();
		
		try {
			PreparedStatement pre = conn.prepareStatement("select * from staff");
		
			ResultSet res = pre.executeQuery();
			while(res.next()) {
				//id, name, email, cont, sub, class_teacher, sal, add, pass, uname			
				 Staff staff = new Staff();
				 staff.setId(res.getInt(1)+"");
					staff.setName(res.getString(2));
					staff.setContact(res.getString(3));
					staff.setEmail(res.getString(4));
					staff.setSalary(res.getString(5));
					staff.setDesignation(res.getString(6));
					staff.setUsername(res.getString(7));
					staff.setPassword(res.getString(8));
				list.add(staff);
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
	public Staff updateStaffById(Staff st) {
		 Staff staff = new Staff();
			
			Connection con = getConnection();
			try {
				PreparedStatement pre1 = con.prepareStatement("update staff set name=?,cont=?,email=?,sal=?,des=?,uname=?,pass=? where id=?");
				pre1.setString(1, st.getName());
				pre1.setString(2, st.getContact());
				pre1.setString(3, st.getEmail());
				pre1.setString(4, st.getSalary());
				pre1.setString(5, st.getDesignation());
				pre1.setString(6, st.getUsername());
				pre1.setString(7, st.getPassword());
				pre1.setInt(8, Integer.parseInt(st.getId()));
				pre1.executeUpdate();
				PreparedStatement pre = con.prepareStatement("select * from staff where id=?");
				pre.setInt(1,Integer.parseInt(st.getId()));
				ResultSet res = pre.executeQuery();
				if(res.next()) {
					//id, name, cont, email, sal, des, uname, pass
					staff.setId(res.getInt(1)+"");
					staff.setName(res.getString(2));
					staff.setContact(res.getString(3));
					staff.setEmail(res.getString(4));
					staff.setSalary(res.getString(5));
					staff.setDesignation(res.getString(6));
					staff.setUsername(res.getString(7));
					staff.setPassword(res.getString(8));
				}
				else {
					return null;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return staff;
	}
	
}
