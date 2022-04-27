package studentmanagement.model;

import java.time.LocalDate;

public class Student {

	String id;
	String name;
	LocalDate dateOfBirth;
	String groupCode;
	
	public Student(String id, String name, LocalDate dateOfBirth, String groupCode) {
		this.id = id;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.groupCode = groupCode;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGroupCode() {
		return groupCode;
	}

	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}

	@Override
	public String toString() {
		return "[" + id + "] " + name;
	}
	
}
