package conexiones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
	
	private Connection con;
	
	public ConexionBD() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/aplicacionescritoriogestionhotel";
			con = DriverManager.getConnection(url,"root", "12345");
		} catch (ClassNotFoundException e) {
			System.out.println("No encuentro el Driver");
		} catch (SQLException e) {
			System.out.println("Error en la conexion [user or pass wrong]");	
		}
		
	}

	public Connection getCon() {
		return con;
	}
	
}
