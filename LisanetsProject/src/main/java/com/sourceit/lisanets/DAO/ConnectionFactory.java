package com.sourceit.lisanets.DAO;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLClassLoader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.sourceit.lisanets.exceptions.ConnectionException;
import com.sourceit.lisanets.servlet.ServletController;

public class ConnectionFactory {
	private static final Logger logger = Logger
			.getLogger(ConnectionFactory.class);
	static InputStream input;
	static final Properties prop = new Properties();

	static {
		try {

			URLClassLoader cl = (URLClassLoader) Thread.currentThread()
					.getContextClassLoader();
			input = cl.getResourceAsStream("config.properties");

			prop.load(input);
		} catch (IOException e) {
			logger.error(e);
	       throw new ConnectionException(e);
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					 logger.error(e);
					 throw new ConnectionException(e);
				}
			}
		}

	}
	static final String user = prop.getProperty("user");
	static final String password = prop.getProperty("password");
	static final String url = prop.getProperty("url");
	static final String driver = prop.getProperty("driver");

	static {

		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			logger.error(e);
			throw new ConnectionException(e);
		}
	}

	public static Connection getConnection() throws SQLException {

		return DriverManager.getConnection(url, user, password);

	}

}
