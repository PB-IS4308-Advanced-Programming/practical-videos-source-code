package studentmanagement.data;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.Properties;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import studentmanagement.model.Student;

public class StudentManagementRepository {

	private static String driver, url, username, password;
	private static ObservableList<String> listOfGroups = FXCollections.observableArrayList();
	private static ObservableList<Student> listOfStudents = FXCollections.observableArrayList();
	
	public static Connection connect() throws Exception {
		Properties property = new Properties();
		InputStream file = StudentManagementRepository.class.getClassLoader().getResourceAsStream("app.properties");
		property.load(file);
		driver = property.getProperty("databaseDriver");
		url = property.getProperty("databaseURL");
		username = property.getProperty("databaseUsername");
		password = property.getProperty("databasePassword");
		Class.forName(driver);
		Connection connection = DriverManager.getConnection(url, username, password);
		return connection;
	}
	
	public static ObservableList<String> getStudentsGroup() {
		listOfGroups.clear();
		Connection connection = null;
		try {
			connection = connect();
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM students_group");
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				String groupCode = resultSet.getString("group_code");
				listOfGroups.add(groupCode);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(connection != null) {
					connection.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listOfGroups;
	}
	
	public static ObservableList<Student> getStudents() {
		listOfStudents.clear();
		Connection connection = null;
		try {
			connection = connect();
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM students");
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				String id = resultSet.getString("id");
				String name = resultSet.getString("name");
				Date dateOfBirth = resultSet.getDate("date_of_birth");
				String groupCode = resultSet.getString("group_code");
				Student student = new Student(id, name, dateOfBirth.toLocalDate(), groupCode);
				listOfStudents.add(student);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(connection != null) {
					connection.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listOfStudents;
	}
	
	public static boolean addStudent(Student student) {
		Connection connection = null;
		try {
			connection = connect();
			String id = student.getId();
			String name = student.getName();
			LocalDate dateOfBirth = student.getDateOfBirth();
			String groupCode = student.getGroupCode();
			PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO students VALUES (?, ?, ?, ?)");
			preparedStatement.setString(1, id);
			preparedStatement.setString(2, name);
			preparedStatement.setDate(3, Date.valueOf(dateOfBirth));
			preparedStatement.setString(4, groupCode);
			
			preparedStatement.executeUpdate();
			
			listOfStudents.add(student);
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(connection != null) {
					connection.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	public static boolean editStudent(Student student) {
		Connection connection = null;
		try {
			connection = connect();
			String id = student.getId();
			String name = student.getName();
			LocalDate dateOfBirth = student.getDateOfBirth();
			String groupCode = student.getGroupCode();
			PreparedStatement preparedStatement = 
					connection.prepareStatement("UPDATE students SET name=?, date_of_birth=?, group_code=? WHERE id=?");
			preparedStatement.setString(1, name);
			preparedStatement.setDate(2, Date.valueOf(dateOfBirth));
			preparedStatement.setString(3, groupCode);
			preparedStatement.setString(4, id);
			
			preparedStatement.executeUpdate();
			
			int selectedIndex = listOfStudents.indexOf(student);
			listOfStudents.set(selectedIndex, null);
			listOfStudents.set(selectedIndex, student);
			
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(connection != null) {
					connection.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
}
