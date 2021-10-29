package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import interaccionbbdd.MiConector;
import turismoenlatierramedia.TipoDeAtraccion;
import turismoenlatierramedia.Usuario;

public class UsuarioDAOImpl implements UsuarioDAO{
	@Override
	public ArrayList<Usuario> getAll() {

		String query = "SELECT usuario.id, usuario.nombre, usuario.cantidad_monedas, usuario.tiempo, tipo_atraccion.nombre AS tipo_favorito FROM usuario JOIN tipo_atraccion ON tipo_atraccion.id = usuario.tipo_atraccion_favorita;";

		ResultSet resultado = null;

		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

		try {
			Connection conn = MiConector.getConnection();
			PreparedStatement statement = conn.prepareStatement(query);
			resultado = statement.executeQuery();

			while (resultado.next()) {
				Usuario usuario = new Usuario(resultado.getInt(1), resultado.getString(2), resultado.getDouble(3),
						resultado.getDouble(4), TipoDeAtraccion.valueOf(resultado.getString(5)));
				System.out.println(usuario);
				usuarios.add(usuario);
			}

		} catch (SQLException e) {
			System.out.println("No se pudo establecer conección con base de datos.");
		}

		return usuarios;
	}
}
