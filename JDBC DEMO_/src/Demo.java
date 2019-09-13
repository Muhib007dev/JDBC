import java.sql.*; //1> Importing Packages
import java.util.Scanner;

public class Demo {

	static String CLASS_PATH = "com.mysql.jdbc.Driver";
	static String URL_PATH = "jdbc:mysql://localhost:3306/jdbcexample";
	static String USER_NAME = "root";
	static String PASSWORD = "macks123";

	public static void main(String... s) throws Exception, SQLException {
		Class.forName(CLASS_PATH); //2>Loading driver classes

		Scanner sc = new Scanner(System.in);

		Connection con = DriverManager.getConnection(URL_PATH, USER_NAME, PASSWORD); //3>Creating Connection to the database

		Operations opt = new Operations();

		int choice = 1;
		
		while(choice==1) {
		
		System.out.println(
				"Enter the choice accordingly: \n1>Show Data \n2>Insert into table \n3>Update Table \n4>Delete from table \n5>Search Students");

		int ch = sc.nextInt(); //This is to select which function to be executed and the con object is passes in each function
		int count = 0;
		switch (ch) {
		case 1:
			opt.displayData(con);
			break;

		case 2:
			count = opt.insertIntoTable(con);
			System.out.println(count+"row/s affected");
			break;
			
		case 3:
			count = opt.updateTable(con);
			System.out.println(count+"row/s affected");
			break;
			
		case 4:
			count=opt.deleteFromTable(con);
			System.out.println(count+"row/s affected");
			break;
			
		case 5:
			opt.searchStudents(con);
			break;

		default:
			break;
		}
		
		System.out.println("Want to check more 1 for yes  0  for no");
		
		choice = sc.nextInt();	
		
	}

		con.close();//7> Closing the connection

	}
}
