package studentmanagement.controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class StudentController {

	@FXML
	TextField idData;
	
	public void add() {
		System.out.println(idData.getText());
	}
	
}
