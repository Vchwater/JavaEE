package web;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import domain.User;

public class User_Dao {
	public boolean UserCheck(String email,String password) {
    	Connection conn = new Dao().Driver();
		try {
			Statement stmt = conn.createStatement();
			ResultSet result = stmt.executeQuery("select * from users");
			while(result.next()) {
				if(email.equals(result.getString("email"))&&password.equals(result.getString("password"))) {
					conn.close();
					return false;
				}
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return true;
    }
	public User finduser(String email) {
		Connection conn = new Dao().Driver();
		try {
			PreparedStatement stmt = conn.prepareStatement("select * from users where email = ?");
			stmt.setString(1,email);
			ResultSet result =  stmt.executeQuery();
			User user = new User();
			while(result.next()) {
				
				user.setId(result.getInt("iduser"));
				user.setName(result.getString("name"));
				user.setEmail(result.getString("email"));
				user.setImage(result.getString("image"));
				user.setBirth(result.getString("birth"));
				user.setPhone(result.getString("phone"));
				user.setSchool(result.getString("school"));
			}
			conn.close();
			return user;	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public boolean adduser(User user) {
		Connection conn = new Dao().Driver();
		try {
			PreparedStatement stmt = conn.prepareStatement("insert into blog.users(name,email,password,birth,phone,school)values(?,?,?,?,?,?)");
			stmt.setString(1,user.getName());
			stmt.setString(2, user.getEmail());
			stmt.setString(3, user.getPassword());
			stmt.setString(4, user.getBirth());
			stmt.setString(5, user.getPhone());
			stmt.setString(6, user.getSchool());
			stmt.executeUpdate();
			conn.close();
			return true;	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public void updateuser(User user) {
		Connection conn = new Dao().Driver();
		try {
			PreparedStatement stmt = conn.prepareStatement("update blog.users set name=?,birth=?,phone=?,school=? where email=?");
			stmt.setString(1,user.getName());
			stmt.setString(2,user.getBirth());
			stmt.setString(3,user.getPhone());
			stmt.setString(4,user.getSchool());
			stmt.setString(5,user.getEmail());
			stmt.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
