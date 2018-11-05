package web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dao {
	public Dao() {
		
	}
	public Connection Driver() {
		String url="jdbc:mysql://localhost:3306/blog";
		String user="root";
		String password="qwenovvz0";
		Connection conn;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("lianjieshibai");
			e.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("数据库连接成功");
			 return conn;
		} catch (SQLException e) {
			System.out.println("数据库连接失败");
			e.printStackTrace();
		}
		return null;
	}
}

