package az.developia.teacher.respository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import az.developia.teacher.entity.TeacherGroupEntity;
import az.developia.teacher.exception.MyRuntimeException;

public class TeacherGroupRepository {

	public void addGroup(TeacherGroupEntity teacherGroup) {
		
		
		String query = "INSERT INTO teacher_group(name,register_date,teacher_id) VALUES "
				+ "('"+teacherGroup.getName()
				+"','"+teacherGroup.getRegister_date()
				+"','"+teacherGroup.getTeacher_id()+"')";
				
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
	
	
	public ArrayList<TeacherGroupEntity> getAllTeacherGroup(Integer id){
		
		ArrayList<TeacherGroupEntity> teacherGroup=new ArrayList<TeacherGroupEntity>();
		
		String query="SELECT * FROM teacher_group where teacher_id='"+id+"';";
		
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/java_teacher?useSSL=false",
					"root", "2004");

			Statement st = conn.createStatement();

//			st.executeUpdate(query);
			
			ResultSet result=st.executeQuery(query);
			
			while (result.next()) {
				TeacherGroupEntity group=new TeacherGroupEntity();
				group.setId(result.getInt("Id"));
				group.setName(result.getString("name"));
				group.setRegister_date(result.getTimestamp("register_date").toLocalDateTime());
				group.setTeacher_id(result.getInt("teacher_id"));
				teacherGroup.add(group);
				
			}
			

			conn.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return teacherGroup;
	}
	
	
	public void deleteGroup(Integer id) {
		String query="DELETE FROM teacher_group WHERE Id='"+id+"';";
		
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
}
