/*
 * 1> Import ---> java.sql.*;
 * 2> Load and register the driver ---> com.mysql.jdbc.Driver
 * 3> Create connection  
 * 4> Create a statement
 * 5> Execute the Query
 * 6> Process the results
 * 7> Close 
 */


import java.sql.*; //1> import packages

public class Session {

	public static void main(String[] args) throws SQLException, Exception {
		Class.forName("com.mysql.jdbc.Driver");//2>Register the driver
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcexample","root","macks123");//3>Create connection
		
		Statement st = con.createStatement();//4>Create Statement
		
		ResultSet rs = st.executeQuery("SELECT * FROM STUDENTS;");//5>Execute query and get the data in ResultSet object.
		
		while(rs.next()) {
			int roll_no = rs.getInt(1);
			String name = rs.getString(2);
			System.out.println("Name:"+name+". Roll no:"+roll_no);
		}
		rs.close();
		st.close();
		con.close();//7>Close connection
	}

}








