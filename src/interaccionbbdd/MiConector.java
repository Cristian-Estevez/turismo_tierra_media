package interaccionbbdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MiConector {
	private static Connection coneccion;
	private static String url = "jdbc:sqlite:data.db";
	
	public static Connection getConnection() throws SQLException{
		if (coneccion == null) {
			coneccion = DriverManager.getConnection(url);
		}
		return coneccion;
	}
}
