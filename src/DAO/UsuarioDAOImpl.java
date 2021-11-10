package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import interaccionbbdd.MiConector;
import turismoenlatierramedia.Atraccion;
import turismoenlatierramedia.Producto;
import turismoenlatierramedia.Promocion;
import turismoenlatierramedia.TipoDeAtraccion;
import turismoenlatierramedia.Usuario;

public class UsuarioDAOImpl extends UsuarioDAO {

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
				usuarios.add(usuario);
			}

		} catch (SQLException e) {
			System.out.println("No se pudo establecer conección con base de datos.");
		}

		return usuarios;
	}

	@Override
	public void persistirUsuario(ArrayList<Usuario> usuarios) {
		String query = "UPDATE usuario SET tiempo = ?, cantidad_monedas = ? WHERE usuario.id = ?;";

		for (Usuario user : usuarios) {

			String idUsuario = Integer.toString(user.getId());
			String tiempo = Double.toString(user.getTiempoDisponible());
			String cantidad_monedas = Double.toString(user.getMonedasDeOro());

			try {
				Connection conn = MiConector.getConnection();
				PreparedStatement statement = conn.prepareStatement(query);
				statement.setString(1, tiempo);
				statement.setString(2, cantidad_monedas);
				statement.setString(3, idUsuario);

				statement.executeUpdate();

			} catch (SQLException e) {
				System.err.println("No se pudo escribir en Base de Datos la información del usuario");
			}

			persistirItinerario(user, user.getProductosComprados());
		}

	}

	private void persistirItinerario(Usuario usuario, List<Producto> productos) {
		String query = "";
		PreparedStatement statement = null;
		int usuarioId = usuario.getId();
		
		try {
			Connection conn = MiConector.getConnection();
			for (int i = usuario.getItinerarioPrevio(); i < productos.size(); i++) {
				if (productos.get(i).esPromocion()) {
					query = "INSERT INTO itinerario(usuario_id, promocion_id) VALUES (?, ?);";
					statement = conn.prepareStatement(query);
					statement.setString(1, Integer.toString(usuarioId));
					statement.setString(2, Integer.toString(productos.get(i).getId()));
				} else if (!productos.get(i).esPromocion()) {
					query = "INSERT INTO itinerario(usuario_id, atraccion_id) VALUES (?, ?);";
					statement = conn.prepareStatement(query);
					statement.setString(1, Integer.toString(usuarioId));
					statement.setString(2, Integer.toString(productos.get(i).getId()));
				}
				statement.executeUpdate();
			}
		} catch (SQLException e) {
			System.err.println("No se pudo escribir en Base de Datos la información del itinerario");
		}

	}

	public void cargarItinerarios(ArrayList<Usuario> usuarios, ArrayList<Atraccion> atracciones, ArrayList<Promocion> promociones) {
		String query = "SELECT itinerario.usuario_id, itinerario.atraccion_id, itinerario.promocion_id FROM itinerario WHERE itinerario.usuario_id = ?";
		PreparedStatement statement= null;
		ResultSet resultado = null;
		
		try {
			Connection conn = MiConector.getConnection();
			for (Usuario unUsuario : usuarios) {
				statement = conn.prepareStatement(query);
				statement.setString(1, Integer.toString(unUsuario.getId()));
				resultado = statement.executeQuery();
				
				while (resultado.next()) {
					int id = resultado.getInt(2);
					if (resultado.wasNull()) {
						id = resultado.getInt(3);
						for (Promocion unaPromocion : promociones) {
							if (id == unaPromocion.getId()) {
								unUsuario.actualizarItinerario(unaPromocion);
							}
						}
						
					} else {
						for (Atraccion unaAtraccion : atracciones) {
							if (id == unaAtraccion.getId()) {
								unUsuario.actualizarItinerario(unaAtraccion);
							}
						}
					}
					unUsuario.incrementarItineraioPrevio();
				}			
			}
		} catch (SQLException e) {
			System.err.println("No se pudo escribir en Base de Datos la información del itinerario");
		}
		
			
	}
}
