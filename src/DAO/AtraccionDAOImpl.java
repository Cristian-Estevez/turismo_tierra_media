package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import interaccionbbdd.MiConector;
import turismoenlatierramedia.Atraccion;
import turismoenlatierramedia.TipoDeAtraccion;

public class AtraccionDAOImpl extends AtraccionDAO {
	
	@Override
	public ArrayList<Atraccion> getAll() {

		String query = "SELECT atraccion.id, atraccion.nombre, atraccion.costo, atraccion.cupo, atraccion.duracion, tipo_atraccion.nombre as TipoDeAtraccion FROM atraccion JOIN tipo_atraccion ON tipo_atraccion.id = atraccion.tipo;";

		ResultSet resultado = null;

		ArrayList<Atraccion> atracciones = new ArrayList<Atraccion>();

		try {
			Connection connection = MiConector.getConnection();
			PreparedStatement statement = connection.prepareStatement(query);
			resultado = statement.executeQuery();

			while (resultado.next()) {
				Atraccion atraccion = new Atraccion(resultado.getInt(1), resultado.getString(2), resultado.getDouble(3),
						resultado.getDouble(5), resultado.getInt(4), TipoDeAtraccion.valueOf(resultado.getString(6)));
				atracciones.add(atraccion);
			}

		} catch (SQLException e) {
			System.out.println("No se pudo establecer coneccion con base de datos.");
		}

		return atracciones;
	}

	@Override
	public void persistirAtraccion(ArrayList<Atraccion> atracciones) {
		String query = "UPDATE atraccion SET cupo = ? WHERE atraccion.id = ?";
		
		for (Atraccion unaAtraccion : atracciones) {
			
			String cupo = Integer.toString(unaAtraccion.getLugaresDisponibles());
			String idAtraccion = Integer.toString(unaAtraccion.getId());
			
			try {
				Connection conn = MiConector.getConnection();
				PreparedStatement statement = conn.prepareStatement(query);
				statement.setString(1, cupo);
				statement.setString(2, idAtraccion);
				
				statement.executeUpdate();
				
			} catch(SQLException e) {
				System.err.println("No se pudo escribir en Base de Datos la información de las atracciones");
			}
			
		}
		
	}
}
