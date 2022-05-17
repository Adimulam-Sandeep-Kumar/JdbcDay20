package ai.jobiak.jdbc;

import java.sql.*;
public class TestJdbc3 {

	public static void main(String[] args) throws Exception {
			      
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		String userName = "root";
		String password = "admin";
		String url ="jdbc:mysql://localhost:3306/world";
		
		Connection con = DriverManager.getConnection(url,userName,password);
		System.out.println("Connected to database -> :)");
		
		Statement st = con.createStatement();
			
		String selectSql = "select * from customer where custid = 15";
		ResultSet rs = st.executeQuery(selectSql);
		
		ResultSetMetaData rsmd = rs.getMetaData();
		
		System.out.println(rsmd.getColumnCount());
		System.out.println(rsmd.getColumnName(1));
		System.out.println(rsmd.getColumnName(2));
		System.out.println(rsmd.getColumnName(3));
		
		System.out.println(rsmd.getColumnTypeName(1));
		System.out.println(rsmd.getColumnTypeName(2));
		System.out.println(rsmd.getColumnTypeName(3));
		
		System.out.println(rsmd.getTableName(1));
	//	System.out.println(rsmd.getSchemaName(1));
		System.out.println(rsmd.getCatalogName(1));
		System.out.println(rsmd.isNullable(1));   // returns true or false
		System.out.println(rsmd.getPrecision(2));
		System.out.println(rsmd.getScale(2));
				
	}
}
