package az.developia.teacher.entity;

import java.util.Objects;

public class TeacherEntity {

	private int Id;
	private String name;
	private String surname;
	private String phone;
	private String address;
	private String username;
	private String password;
	
	public TeacherEntity(int id, String name, String surname, String phone, String address, String username,
			String password) {
		super();
		Id = id;
		this.name = name;
		this.surname = surname;
		this.phone = phone;
		this.address = address;
		this.username = username;
		this.password = password;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "TeacherEntity [Id=" + Id + ", name=" + name + ", surname=" + surname + ", phone=" + phone + ", address="
				+ address + ", username=" + username + ", password=" + password + "]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(Id, address, name, password, phone, surname, username);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TeacherEntity other = (TeacherEntity) obj;
		return Id == other.Id && Objects.equals(address, other.address) && Objects.equals(name, other.name)
				&& Objects.equals(password, other.password) && Objects.equals(phone, other.phone)
				&& Objects.equals(surname, other.surname) && Objects.equals(username, other.username);
	}
	
	
}