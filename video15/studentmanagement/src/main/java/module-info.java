module studentmanagement {
	requires javafx.base;
	requires javafx.controls;
	requires javafx.fxml;
	requires transitive javafx.graphics;
	
	opens studentmanagement to javafx.fxml;
	opens studentmanagement.controller to javafx.fxml;
	exports studentmanagement;
	exports studentmanagement.controller;
	exports studentmanagement.model;
}