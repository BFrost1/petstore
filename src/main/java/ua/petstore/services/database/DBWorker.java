package ua.petstore.services.database;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.stereotype.Component;

@Component
public class DBWorker {
	private Logger logger = Logger.getLogger(DBWorker.class.getName());

	public DBWorker() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException | ClassNotFoundException e) {
			logger.log(Level.INFO, e.getMessage());
		}
	}

	public Connection getConnection() {
		Properties configuration = new Properties();
		Connection con = null;
		try (InputStream in = getClass().getClassLoader().getResourceAsStream("database.properties")) {
			configuration.load(in);
			con = DriverManager.getConnection(configuration.getProperty("url"), configuration.getProperty("username"),
					configuration.getProperty("password"));
		} catch (IOException e) {
			System.out.println(e.getMessage());
			logger.log(Level.INFO, e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			logger.log(Level.INFO, e.getMessage());
		}
		return con;
	}
}
