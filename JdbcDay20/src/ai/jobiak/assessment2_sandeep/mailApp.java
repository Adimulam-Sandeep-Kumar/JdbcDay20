package ai.jobiak.assessment2_sandeep;

import java.sql.*;
import java.util.Scanner;
public class mailApp {

	public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		String userName = "root";
		String password = "admin";
		String url = "jdbc:mysql://localhost:3306/sandeep";
		
		Connection con = DriverManager.getConnection(url,userName,password);
		System.out.println("Database Connected :)");
		
//		int num[] = {1,2,3,4,5};
//		String name[] = {"Sandeep","Hemanth","Venkat","Paramesh","Praneeth"};
//		String subject[] = {"assessment2","assessment2","assessment2","assessment2","assessment2"};
//		String content[] = {"please validate the code","please validate the code","please validate the code","please validate the code","please validate the code"};
//		
//		for(int i=0;i<name.length;i++) {
//			PreparedStatement pst = con.prepareStatement("insert into mailApp values(?,?,?,?,?)");
//			pst.setInt(1, num[i]);
//			pst.setString(2, name[i]);
//			pst.setString(3, subject[i]);
//			pst.setString(4, content[i]);
//			pst.setInt(5, content[i].length());
//			pst.executeUpdate();
//			
//			System.out.println("");
//			System.out.println("Record Inserted");		
//		}
		
		  while(true) {
		  
		  System.out.println("Menu"); 
		  System.out.println("----------------");
		  System.out.println("1.First"); 
		  System.out.println("2.Next");
		  System.out.println("3.Previous");
		  System.out.println("4.Last");
		  System.out.println("5.Go to #"); 
		  System.out.println("6.Exit");
		  System.out.println("Enter the Option : ");
		  
		  Scanner sc = new Scanner(System.in); 
		  
		  Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
		  String selectsql = "select * from mailApp";
		  ResultSet rs = st.executeQuery(selectsql);
		  int option = sc.nextInt();
		  switch(option) {
		  
		  case 1:
			 			  
			  rs.first();
			  System.out.println(rs.getString(1)+"::"+rs.getString(2)+"::"+rs.getString(3)+"::"+rs.getString(4)+"::"+rs.getString(5));
			  break;
		
		  case 2:
			  
			  rs.first();
			  rs.next();
			  System.out.println(rs.getString(1)+"::"+rs.getString(2)+"::"+rs.getString(3)+"::"+rs.getString(4)+"::"+rs.getString(5));
			  break;
		
		  case 3:
			  
			  rs.first();
			  rs.next();
			  rs.previous();
			  System.out.println(rs.getString(1)+"::"+rs.getString(2)+"::"+rs.getString(3)+"::"+rs.getString(4)+"::"+rs.getString(5));
			  break;
			
		  case 4:
			  
			  rs.afterLast();
			  rs.last();
			  System.out.println(rs.getString(1)+"::"+rs.getString(2)+"::"+rs.getString(3)+"::"+rs.getString(4)+"::"+rs.getString(5));
			  break;
			  
		  case 5:
			  
			  System.out.println("Enter the Mail Number : ");		  
			  int num = sc.nextInt();
			  rs.absolute(num);
			  System.out.println(rs.getString(1)+"::"+rs.getString(2)+"::"+rs.getString(3)+"::"+rs.getString(4)+"::"+rs.getString(5));
			  break;
			  
		  case 6:
			  
			  System.out.println("Exited");
			  break;
			  
		  default:
			
			System.out.println("Please enter a valid Option");
			
		  
		  }
		  
		  }
	}
}
