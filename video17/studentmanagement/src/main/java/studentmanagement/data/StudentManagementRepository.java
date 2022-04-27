package studentmanagement.data;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class StudentManagementRepository {

	private static String driver, url, username, password;
	
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
	
	
	
}
