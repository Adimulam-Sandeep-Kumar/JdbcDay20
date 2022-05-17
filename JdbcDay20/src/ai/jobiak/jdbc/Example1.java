package ai.jobiak.jdbc;

import java.sql.*;

public class Example1 {

	public static void main(String[] args) {
	

		try {
			
			//driver loading
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//connection creating
			String userName = "root";
			String password = "admin";
			String url ="jdbc:mysql://localhost:3306/sandeep";
			Connection con = DriverManager.getConnection(url,userName,password);
			
			/*
			 * if(con.isClosed()) { System.out.println("Connection not Established"); }else
			 * { System.out.println("Connection Established"); }
			 */
			
			//Query Creating
			
			String q = "CREATE TABLE STUDENT"+"(stdId INTEGER not NULL,"+"stdName VARCHAR(90),"+"stdAge INTEGER not NULL,"+"PRIMARY KEY(stdId))";
			
			//Statement Creating
			Statement st = con.createStatement();
			st.executeUpdate(q);
			
			System.out.println("Created Table Successfully");
			con.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
