package com.sourceit.lisanets.DAO;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLClassLoader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {

	//static FileInputStream input;
static InputStream input;
	static final Properties prop = new Properties();

	static{
	try{
		
		//input = new FileInputStream("src/main/resources/config.properties");
		
		URLClassLoader cl =  (URLClassLoader)	Thread.currentThread().getContextClassLoader();
		input =   cl.getResourceAsStream("config.properties");
		//input = new FileInputStream("WEB-INF/classes/config.properties");
	   
		prop.load(input);
	     } catch (IOException e){
	    	 e.printStackTrace();
	     } finally{
	    	 if (input != null){
	    		 try {
					input.close();
				} catch (IOException e) {
					
					e.printStackTrace();
				}
	    	 }
	     }
	

	
}
	static final String user = prop.getProperty("user");
	static  final  String password = prop.getProperty("password");
	static  final  String url = prop.getProperty("url");
	static  final   String driver = prop.getProperty("driver");

	static{
		
		
		
	
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	public static Connection getConnection() throws SQLException {
		
		return DriverManager.getConnection(url, user, password);
		
		
	}
	
}
