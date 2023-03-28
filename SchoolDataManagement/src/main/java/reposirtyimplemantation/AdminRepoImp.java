package reposirtyimplemantation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import repository.AdminRepository;
import schooldataclasses.Admin;
public class AdminRepoImp implements AdminRepository {

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
	public String saveAdmin(Admin admin) {
		Connection con = getConnection();
		try {
			PreparedStatement pre = con.prepareStatement("insert into admin(name,pass) values (?,?)");
			pre.setString(1, admin.getUsername());
			pre.setString(2, admin.getPassword());
		    pre.executeUpdate();
		    con.close();
		} catch (SQLException e) {
			return null;
		}
		return "valid";
	}
	@Override
	public Admin adminLogin(String username, String password) {
		Connection con = getConnection();
		Admin a=null;
		try {
			PreparedStatement pre = con.prepareStatement("select * from admin where name=? and pass=?");
			pre.setString(1, username);
			pre.setString(2, password);
			ResultSet exe = pre.executeQuery();
			if(!exe.next()) return null;
			a = new Admin();
			a.setId(exe.getInt(1)+"");
			a.setUsername(exe.getString(2));
			a.setPassword(exe.getString(3));
		    con.close();
		} catch (SQLException e) {
			return null;
		}
		return a;
	}

	
}
