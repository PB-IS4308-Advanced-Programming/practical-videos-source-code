module studentmanagement {
	requires javafx.base;
	requires javafx.controls;
	requires javafx.fxml;
	requires transitive javafx.graphics;
	requires transitive java.sql;
	
	opens studentmanagement to javafx.fxml;
	opens studentmanagement.controller to javafx.fxml;
	exports studentmanagement;
	exports studentmanagement.controller;
	exports studentmanagement.model;
	exports studentmanagement.data;
}