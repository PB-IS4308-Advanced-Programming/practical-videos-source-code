package studentmanagement.controller;

import java.time.LocalDate;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import studentmanagement.data.StudentManagementRepository;
import studentmanagement.model.Student;

public class StudentController {

	@FXML
	TextField idData, nameData;
	
	@FXML
	DatePicker dOBData;
	
	@FXML
	ComboBox<String> groupData;
	
	@FXML
	ListView<Student> studentsList;
	
	@FXML
	Label warning;
	
	public void initialize() throws Exception {
		groupData.setItems(StudentManagementRepository.getStudentsGroup());
		studentsList.setItems(StudentManagementRepository.getStudents());
	}
	
	public void add() {
		String id = idData.getText();
		String name = nameData.getText();
		LocalDate dateOfBirth = dOBData.getValue();
		String groupCode = groupData.getSelectionModel().getSelectedItem();
		Student newStudent = new Student(id, name, dateOfBirth, groupCode);
		studentsList.getItems().add(newStudent);
		
		clear();
	}
	
	public void edit() {
		Student student = studentsList.getSelectionModel().getSelectedItem();
		String name = nameData.getText();
		LocalDate dateOfBirth = dOBData.getValue();
		String groupCode = groupData.getSelectionModel().getSelectedItem();
		
		student.setName(name);
		student.setDateOfBirth(dateOfBirth);
		student.setGroupCode(groupCode);
		
		int selectedIndex = studentsList.getSelectionModel().getSelectedIndex();
		studentsList.getItems().set(selectedIndex, null);
		studentsList.getItems().set(selectedIndex, student);
		
		clear();
	}
	
	public void cancelEdit() {
		System.out.println("cancelEdit method");
	}
	
	public void delete() {
		Student student = studentsList.getSelectionModel().getSelectedItem();
		studentsList.getItems().remove(student);
		
		clear();
	}
	
	public void showStudent() {
		Student student = studentsList.getSelectionModel().getSelectedItem();
		if(student != null) {
			idData.setText(student.getId());
			nameData.setText(student.getName());
			dOBData.setValue(student.getDateOfBirth());
			int groupCodeIndex = groupData.getItems().indexOf(student.getGroupCode());
			groupData.getSelectionModel().select(groupCodeIndex);
		}
	}
	
	public void clear() {
		idData.clear();
		nameData.clear();
		dOBData.setValue(null);
		groupData.getSelectionModel().clearSelection();
		studentsList.getSelectionModel().clearSelection();
	}
}
