package az.developia.teacher;


import java.time.LocalDateTime;

import az.developia.teacher.entity.TeacherEntity;
import az.developia.teacher.entity.TeacherGroupEntity;
import az.developia.teacher.exception.MyRuntimeException;
import az.developia.teacher.repository.TeacherGroupRepository;
import az.developia.teacher.repository.TeacherRepository;

public class TeacherMain {
public static void main(String[] args) {
	
	TeacherEntity teacher=new TeacherEntity
			(0, "Elrahim", "Elizade", "051", "nizami st.", "elirahim1", "1234");
	
	TeacherRepository repo=new TeacherRepository();
	
	TeacherGroupEntity teacherGroup=new TeacherGroupEntity(null, "a3", LocalDateTime.now(), 6);
	
	TeacherGroupRepository groupRepo=new TeacherGroupRepository();
//	groupRepo.addGroup(teacherGroup);
	groupRepo.deleteGroup(3);
	System.out.println(groupRepo.getAllTeacherGroup(6));
	
	
	try {
		String username=teacher.getUsername();
		String password=teacher.getPassword();
		
		if (repo.login(username, password)) {
			System.out.println("Login oldun");
		}else {
			System.out.println("Istifadeci adi ve ya parol yalnisdir!");
		}
		
		if (repo.checkUser(teacher.getUsername())) {
			System.out.println("Bu istifadeci artiq movcuddur");
		}
		else {
			repo.add(teacher);
		}
		
	} catch (MyRuntimeException e) {
		System.out.println(e.getMyMessage());
	}
}
}