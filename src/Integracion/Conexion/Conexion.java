package Integracion.Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	
	
	private Connection conexion;
	private static final String CONTROLLER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/gest_pharma";
	private static final String USER = "gestpharma";
	private static final String PASSWORD = "gestpharmaadmin1";
	
	public Conexion() {
		
	}
	
	
	//carga el controlador solo una vez, al cargar la aplicacion, no es necesario llamar a ningun metodo
	static {
		try {
			Class.forName(CONTROLLER);
		}catch(ClassNotFoundException e) {
			System.out.println("Error en conexion con el Driver");
		}
	}
	
	public Connection performConnection() throws SQLException {
		
		try {
			
			
			conexion = DriverManager.getConnection(URL, USER, PASSWORD);
			
			System.out.println("Conectado a BD");
			
			
		
		}catch(SQLException e) {
			throw new SQLException("No se ha conectado con BD");
		}

		return conexion;
	}
	
	public void closeConnection() throws SQLException {
		
		if(conexion != null && !conexion.isClosed()) {
			conexion.close();
		}
	}
	
}
