package ai.jobiak.jdbc;

import java.sql.*;
public class TestJdbc4 {

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
		String url ="jdbc:mysql://localhost:3306/sandeep";
	
		Connection con = DriverManager.getConnection(url,userName,password);

		try (Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
				ResultSet rs = st.executeQuery("select * from sandeep.employee"))
				{
				        System.out.println(rs.getFetchSize());
				     //   rs.
				       //       rs.setFetchSize(10);
				      rs.next();    
				      System.out.println( rs.getInt(1) + "," + rs.getInt(6));
				     // rs.last();
				      rs.absolute(-13);
				      System.out.println( rs.getInt(1) + "," + rs.getInt(6));
				      rs.first();    
				      System.out.println( rs.getInt(1) + "," + rs.getInt(6));
				     
				}catch(SQLException  | RuntimeException e ) {
				e.printStackTrace();
				// System.out.println(rs);
				}

	}

}
