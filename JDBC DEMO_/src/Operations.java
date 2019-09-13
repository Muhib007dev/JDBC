
import java.sql.*;
import java.util.Scanner;

public class Operations {
	int insertIntoTable(Connection con) throws SQLException, ClassNotFoundException {

		Statement st = con.createStatement();//4>Creating the statement object

		Scanner sc = new Scanner(System.in); 
		System.out.println("Enter the name of student");
		String name = sc.next();
		System.out.println("Enter the roll_no of student");
		int roll_no = sc.nextInt();

		int count = st.executeUpdate("INSERT INTO STUDENTS VALUES('" + roll_no + "','" + name + "');"); //5>Executing the query

		st.close();
		//con.close();

		return count;

	}

	int updateTable(Connection con) throws SQLException {

		Statement st = con.createStatement();

		Scanner obj = new Scanner(System.in);

		System.out.println(
				"Do you want to update name or roll no? type name to update name and roll_no to update roll number");
		String choice = obj.next();

		int count = 0;
		int roll_no;
		String name;
		String query;
		switch (choice) {
		case "name":
			System.out.println("Enter the roll no of student of which you want to update the name of student");
			roll_no = obj.nextInt();
			System.out.println("Enter the name you want to update");
			name = obj.next();

			query = "UPDATE STUDENTS SET name='" + name + "' WHERE roll_no='" + roll_no + "'";

			
			try {
				count = st.executeUpdate(query);
			} catch (SQLException e) {

				e.printStackTrace();
			} finally {
				st.close();
				//con.close();
			}
			break;

		case "roll_no":
			System.out.println("Enter the name of student of which you want to update the roll no of student");
			name = obj.next();
			System.out.println("Enter the roll_no you want to update");
			roll_no = obj.nextInt();

			query = "UPDATE STUDENTS SET roll_no=" + roll_no + " WHERE name='" + name + "'";

			
			try {
				count = st.executeUpdate(query);
			} catch (SQLException e) {

				e.printStackTrace();
			}

			finally {
				st.close();
				//con.close();
			}

			break;

		default:
			break;
		}

		return count;

	}

	int deleteFromTable(Connection con) throws SQLException {

		Statement st = con.createStatement();

		System.out.println("Do you want to delete student data by name or by roll no. Type name or roll_no:");
		Scanner sc = new Scanner(System.in);
		String choice = sc.next();
		int count = 0;

		switch (choice) {
		case "name":
			try {
				System.out.println("Enter the name of student:");
				String name = sc.next();
				count = st.executeUpdate("DELETE FROM STUDENTS WHERE name='" + name + "'");
			} catch (SQLException e) {

				e.printStackTrace();
			} finally {
				st.close();
				//con.close();
			}
			break;

		case "roll_no":
			try {
				System.out.println("Enter the roll no of student:");
				String roll_no = sc.next();
				count = st.executeUpdate("DELETE FROM STUDENTS WHERE roll_no=" + roll_no);
			} catch (SQLException e) {

				e.printStackTrace();
			} finally {
				st.close();
				//con.close();
			}

			break;

		default:
			break;
		}
		return count;

	}

	void displayData(Connection con) throws SQLException {

		try {
			Statement st = con.createStatement(); //4>Creating statement object
			ResultSet rs = st.executeQuery("SELECT * FROM STUDENTS"); //5>Executing the query
			while (rs.next()) { //6>Processing the result
				int roll_no = rs.getInt(1);
				String name = rs.getString(2);
				System.out.println("Name:-" + name + ". Roll no:-" + roll_no);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//con.close();
		}

	}

	void searchStudents(Connection con) throws SQLException {
		Scanner sc = new Scanner(System.in);

		System.out.println("Search student by name or roll no. Type 'name' or 'roll_no'");

		Statement st = con.createStatement();
		String choice = sc.next();

		switch (choice) {
		case "roll_no":
			System.out.println("Enter the roll no:");
			int roll_no = sc.nextInt();
			ResultSet rs1;
			try {
				rs1 = st.executeQuery("SELECT * FROM STUDENTS WHERE roll_no=" + roll_no);
				while (rs1.next()) {
					int tRollNo = rs1.getInt(1);
					String tName = rs1.getString(2);
					System.out.println("Name" + tName + " Roll no." + tRollNo);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
				st.close();
				//con.close();
			}
			
			break;
		case "name":
			System.out.println("Enter the name:");
			String name = sc.next();
			ResultSet rs2;
			try {
				rs2 = st.executeQuery("SELECT * FROM STUDENTS WHERE name='" + name+"'");
				while (rs2.next()) {
					int rollNo = rs2.getInt(1);
					String tName = rs2.getString(2);
					System.out.println("Name:" + tName + " Roll no.:" + rollNo);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
				st.close();
				//con.close();
			}
			break;

		default:
			break;
		}
	}
}
