package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import interaccionbbdd.MiConector;
import turismoenlatierramedia.TipoDeAtraccion;
import turismoenlatierramedia.Usuario;

public class UsuarioDAO {
	
	public ArrayList<Usuario> getAll(){

		String query = "SELECT usuario.nombre, usuario.cantidad_monedas, usuario.tiempo, "
				+ "tipo_atraccion.nombre "
				+ "FROM usuario "
				+ "JOIN tipo_atraccion ON tipo_atraccion.id = usuario.tipo_atraccion_favorita;";
		
		ResultSet resultado = null;
		
		ArrayList<Usuario>  usuarios = new ArrayList<Usuario>();

		try {
			Connection conn = MiConector.getConnection();
			PreparedStatement statement = conn.prepareStatement(query);
			resultado = statement.executeQuery();
			
			while (resultado.next()) {
				Usuario usuario = new Usuario(resultado.getString(1), resultado.getInt(2), resultado.getDouble(3), TipoDeAtraccion.valueOf(resultado.getString(4)));
				usuarios.add(usuario);
				}
			
		} catch (SQLException e) {
			System.out.println("No se pudo establecer conección con base de datos.");
		}
	
		return usuarios;
	}
	
	
	
}
