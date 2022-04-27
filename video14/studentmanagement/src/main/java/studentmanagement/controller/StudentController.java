package studentmanagement.controller;

import java.time.LocalDate;

import javafx.fxml.FXML;
import javafx.scene.control.*;
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
	
	public void add() {
		String id = idData.getText();
		String name = nameData.getText();
		LocalDate dateOfBirth = dOBData.getValue();
		String groupCode = groupData.getSelectionModel().getSelectedItem();
		Student newStudent = new Student(id, name, dateOfBirth, groupCode);
		studentsList.getItems().add(newStudent);
		
		idData.clear();
		nameData.clear();
		dOBData.setValue(null);
		groupData.getSelectionModel().clearSelection();
	}
	
	public void edit() {
		System.out.println("edit method");
	}
	
	public void cancelEdit() {
		System.out.println("cancelEdit method");
	}
	
	public void delete() {
		System.out.println("delete method");
	}
	
	public void showStudent() {
		System.out.println("showStudent method");
	}
}
