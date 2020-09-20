package utility;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManager {
	
public static Connection getConnection() throws IOException, SQLException, ClassNotFoundException {
		
		Properties prop= null;
		prop=loadFileProperties();
		
		final String driver=prop.getProperty("driver");
		final String url=prop.getProperty("url");
		final String username=prop.getProperty("username");
		final String password=prop.getProperty("password");
		
		Class.forName(driver);
		
		Connection con =null;
		
		con=DriverManager.getConnection(url,username,password);
		
//		if( con != null) {
//			System.out.println(" Data Fetch Successfully");
//		}
		return con;
		
		
	}
	
	public static Properties loadFileProperties() throws IOException {
		
		Properties prop= new Properties();
		InputStream in = ConnectionManager.class.getClassLoader().getResourceAsStream("jdbc.properties");
		prop.load(in);
		in.close();
		return prop;
	}
}
