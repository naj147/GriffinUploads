package bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	private static ConnectionFactory instance= new ConnectionFactory();
	public static final String URL = "jdbc:mysql://localhost/upld";
	/*
	 * Faut faire ça dans la console MYSQL pour crée un user JEE pour 
	 * que le code suivant tourne
	 * CREATE USER 'jee'@'localhost' IDENTIFIED BY 'jee';
	 * GRANT ALL ON bdd_sdzee.* TO 'jee'@'localhost' IDENTIFIED BY 'jee';
	 */
	public static final String USER = "jee";
	public static final String PASSWORD = "jee";
	public static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";
	
	private ConnectionFactory (){
		try{
			Class.forName(DRIVER_CLASS);
		}catch (ClassNotFoundException e){
			e.printStackTrace();
		}
	}
	private Connection createConnection(){
		Connection connection=null;
		try{
			connection = DriverManager.getConnection(URL,USER,PASSWORD);
		}catch (SQLException e){
			System.out.println("ERROR : Unable to connect to DATABASE.");
		}
		return connection ;	
	}
	public static Connection getConnection () {
		return instance.createConnection();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
