package az.developia.teacher.entity;


import java.time.LocalDateTime;
import java.util.Objects;

public class TeacherGroupEntity {

	private Integer id;
	private String name;
	private LocalDateTime register_date;
	private Integer teacher_id;
	
	
	public TeacherGroupEntity(Integer id, String name, LocalDateTime register_date, Integer teacher_id) {
		super();
		this.id = id;
		this.name = name;
		this.register_date = register_date;
		this.teacher_id = teacher_id;
	}
	
	public TeacherGroupEntity() {
		// TODO Auto-generated constructor stub
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDateTime getRegister_date() {
		return register_date;
	}
	public void setRegister_date(LocalDateTime register_date) {
		this.register_date = register_date;
	}
	public Integer getTeacher_id() {
		return teacher_id;
	}
	public void setTeacher_id(Integer teacher_id) {
		this.teacher_id = teacher_id;
	}
	@Override
	public String toString() {
		return "TeacherGroupEntity [id=" + id + ", name=" + name + ", register_date=" + register_date + ", teacher_id="
				+ teacher_id + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(id, name, register_date, teacher_id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TeacherGroupEntity other = (TeacherGroupEntity) obj;
		return Objects.equals(id, other.id) && Objects.equals(name, other.name)
				&& Objects.equals(register_date, other.register_date) && Objects.equals(teacher_id, other.teacher_id);
	}
	
	
}
