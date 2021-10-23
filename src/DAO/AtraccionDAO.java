package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import interaccionbbdd.MiConector;
import turismoenlatierramedia.Atraccion;
import turismoenlatierramedia.TipoDeAtraccion;

public class AtraccionDAO {
	public ArrayList<Atraccion> getAll() {

		String query = "SELECT atraccion.nombre, atraccion.costo, atraccion.cupo, atraccion.duracion, tipo_atraccion.nombre as TipoDeAtraccion FROM atraccion JOIN tipo_atraccion ON tipo_atraccion.id = atraccion.tipo;";

		ResultSet resultado = null;

		ArrayList<Atraccion> atracciones = new ArrayList<Atraccion>();

		try {
			Connection connection = MiConector.getConnection();
			PreparedStatement statement = connection.prepareStatement(query);
			resultado = statement.executeQuery();

			while (resultado.next()) {
				Atraccion atraccion = new Atraccion(resultado.getString(1), resultado.getDouble(2), resultado.getDouble(4), resultado.getInt(3),TipoDeAtraccion.valueOf(resultado.getString(5)));
				atracciones.add(atraccion);
			}

		} catch (SQLException e) {
			System.out.println("No se pudo establecer coneccion con base de datos.");
		}

		return atracciones;
	}
}
