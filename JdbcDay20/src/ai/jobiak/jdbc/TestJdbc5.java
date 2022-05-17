package ai.jobiak.jdbc;

import java.sql.*;
public class TestJdbc5 {

	public static void main(String[] args) throws SQLException {
		
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
	
		Connection con = DriverManager.getConnection(url,userName,password);

		
		try (Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
				ResultSet rs = st.executeQuery("select deptno,dname,loc from dept"))
				{
//				     rs.
				rs.next();
				System.out.println(rs.getInt(1) + "," + rs.getString(2));
				/*
				* rs.moveToInsertRow(); rs.updateInt(1,70); rs.updateString(2,"Timepass3");
				* rs.updateString(3, "Miami3"); rs.insertRow();
				*
				* // rs.last(); //s rs.refreshRow();
				*
				* System.out.println(rs.getInt(1) + "," + rs.getString(2));
				*/

				/*
				* rs.last(); rs.updateString(2,"Advertising"); rs.updateString(3,"Nevada");
				* rs.updateRow();
				*/
				rs.absolute(5);
				System.out.println(rs.getInt(1) + "," + rs.getString(2));
				rs.deleteRow();
				System.out.println(rs.getInt(1) + "," + rs.getString(2)); // note pointer moves one row up and fetches fourth row
				}catch(SQLException  | RuntimeException e ) {
				e.printStackTrace();
				// System.out.println(rs);
				}
	
	}
}
