package com.yan.common.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectToSQL {
	
	private static Connection conn;
	
	private static Statement st;
	
	
	static{
		try {
			// 加载MySql的驱动类
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("找不到驱动程序类 ，加载驱动失败！");
			e.printStackTrace();
		}
		
		String url = "jdbc:mysql://localhost:3306/attendance";
		String username = "root";
		String password = "root";
		try {
			conn = DriverManager.getConnection(url, username,
					password);
			
			st = conn.createStatement();
			
		} catch (SQLException se) {
			System.out.println("数据库连接失败！");
			se.printStackTrace();
		}
	}
	
	public static Connection getConn() {

		return conn;
	}

	public static Statement getSt(Connection c){
		
		return st;
	}
	
}
