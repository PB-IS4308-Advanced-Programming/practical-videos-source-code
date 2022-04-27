package studentmanagement.controller;

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
		System.out.println("add method");
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
