package ai.jobiak.jdbc;

import java.sql.*;
public class TestJdbc2 {

	public static void main(String[] args) {
		
		//1. Load the driver class
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		
		//2. Connect with driver manager
		String userName = "root";
		String password = "admin";
		String url ="jdbc:mysql://localhost:3306/world";
	
		try {
			Connection con = DriverManager.getConnection(url,userName,password);
			System.out.println("Connected to db -> :)");
			
			DatabaseMetaData dmd = con.getMetaData();
			System.out.println(dmd.getDriverName());
			System.out.println(dmd.getDriverVersion());
			System.out.println(dmd.getDatabaseProductName());
			System.out.println(dmd.getDriverMinorVersion());
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
