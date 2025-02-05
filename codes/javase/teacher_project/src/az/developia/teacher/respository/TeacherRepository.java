package az.developia.teacher.respository;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import az.developia.teacher.entity.TeacherEntity;
import az.developia.teacher.exception.MyRuntimeException;

public class TeacherRepository {

	public void add(TeacherEntity teacher) throws MyRuntimeException {

		if (teacher.getName().length() > 45) {
			throw new MyRuntimeException("Ad max 45 simvol ola biler");
		}

		String query = "INSERT INTO teacher(name,surname,phone,address,username,password) VALUES " + "('"
				+ teacher.getName() + "','" + teacher.getSurname() + "','" + teacher.getPhone() + "','"
				+ teacher.getAddress() + "','" + teacher.getUsername() + "','" + teacher.getPassword() + "')";

		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/java_teacher?useSSL=false",
					"root", "2004");

			Statement st = conn.createStatement();

			st.executeUpdate(query);

			conn.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
	
	//Librarian Kitabxanaciucun
	//members

	public boolean checkUser(String username) {

		boolean userExists = false;

		String query = "SELECT count(*) FROM teacher where username='" + username + "';";

		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/java_teacher?useSSL=false",
					"root", "2004");

			Statement st = conn.createStatement();

//			st.executeUpdate(query);
			ResultSet result = st.executeQuery(query);

			result.next();

			userExists = result.getInt(1) == 1 ? true : false;

			conn.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return userExists;

	}
	
	
	public boolean login(String username, String password) {

		boolean userExists = false;

		String query = "SELECT count(*) FROM teacher where username='" + username + "' and password='"+password+"';";

		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/java_teacher?useSSL=false",
					"root", "2004");

			Statement st = conn.createStatement();

//			st.executeUpdate(query);
			ResultSet result = st.executeQuery(query);

			result.next();

			userExists = result.getInt(1) == 1 ? true : false;

			conn.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return userExists;

	}
	
}
