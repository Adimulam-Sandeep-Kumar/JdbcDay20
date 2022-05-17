package ai.jobiak.jdbc;

import java.sql.*;
public class TestJdbc1 {

	public static void main(String[] args) {
		
		//1. Load the driver class
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		
		//2. Connecting with driver manager
		String userName = "root";
		String password = "admin";
		String url ="jdbc:mysql://localhost:3306/world";
	
		try {
			Connection con = DriverManager.getConnection(url,userName,password);
			System.out.println("Connected to db successfully -> :)");
			
			Statement st = con.createStatement();
			String selectSQL = "select *from customer where custId = 15";
			
			ResultSet rs = st.executeQuery(selectSQL);
			
			while(rs.next()) {
				System.out.println("Data Found");
				System.out.println(rs.getString(1)+"::"+rs.getString(2)+"::"+rs.getString(3));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
