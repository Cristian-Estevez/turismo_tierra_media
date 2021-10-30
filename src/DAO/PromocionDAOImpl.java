package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import interaccionbbdd.MiConector;
import turismoenlatierramedia.Atraccion;
import turismoenlatierramedia.Promocion;
import turismoenlatierramedia.PromocionAbsoluta;
import turismoenlatierramedia.PromocionAxB;
import turismoenlatierramedia.PromocionPorcentual;
import turismoenlatierramedia.TipoDeAtraccion;

public class PromocionDAOImpl implements PromocionDAO {

	@Override
	public ArrayList<Promocion> getAll(ArrayList<Atraccion> atracciones) {

		String queryPromociones = "SELECT tipo_promocion.nombre AS tipo_de_promocion, promocion.id AS id, tipo_atraccion.nombre AS tipo_de_atraccion, promocion.nombre, promocion.descuento_costo, atraccion.nombre AS atraccion_bonificada FROM promocion JOIN tipo_promocion ON tipo_promocion.id = promocion.tipo_promocion JOIN tipo_atraccion ON tipo_atraccion.id = promocion.tipo_atraccion LEFT JOIN atraccion ON atraccion.id = promocion.atraccion_id;";
		String queryAtraccionesIncluidas = "SELECT atraccion_promocion.atraccion_id FROM atraccion_promocion WHERE atraccion_promocion.promocion_id = ?;";
		ResultSet resultadoPromociones = null;
		ResultSet resultadoAtracciones = null;

		ArrayList<Promocion> promociones = new ArrayList<Promocion>();

		try {
			Connection conn = MiConector.getConnection();
			PreparedStatement statementPromociones = conn.prepareStatement(queryPromociones);
			resultadoPromociones = statementPromociones.executeQuery();

			Promocion promocion = null;
			while (resultadoPromociones.next()) {
				ArrayList<Atraccion> atraccionesIncluidas = new ArrayList<Atraccion>();
				String promoActualId = resultadoPromociones.getString(2);
				PreparedStatement statementAtraccionesIncluidas = conn.prepareStatement(queryAtraccionesIncluidas);
				statementAtraccionesIncluidas.setString(1, promoActualId);
				resultadoAtracciones = statementAtraccionesIncluidas.executeQuery();

				while (resultadoAtracciones.next()) {
					for (Atraccion tmp : atracciones) {
						if (tmp.getId() == resultadoAtracciones.getInt(1)) {
							atraccionesIncluidas.add(tmp);
						}
					}

				}

				String tipoDePromocion = resultadoPromociones.getString(1);
				if (tipoDePromocion.equalsIgnoreCase("axb")) {
					promocion = new PromocionAxB(resultadoPromociones.getInt(2), resultadoPromociones.getString(4),
							TipoDeAtraccion.valueOf(resultadoPromociones.getString(3)), atraccionesIncluidas);
				} else if (tipoDePromocion.equalsIgnoreCase("porcentual")) {
					promocion = new PromocionPorcentual(resultadoPromociones.getInt(2), resultadoPromociones.getString(4), TipoDeAtraccion.valueOf(resultadoPromociones.getString(3)), resultadoPromociones.getDouble(5), atraccionesIncluidas);
				} else if (tipoDePromocion.equalsIgnoreCase("absoluta")) {
					promocion = new PromocionAbsoluta(resultadoPromociones.getInt(2), resultadoPromociones.getString(4), TipoDeAtraccion.valueOf(resultadoPromociones.getString(3)), resultadoPromociones.getDouble(5), atraccionesIncluidas);
				}

				promociones.add(promocion);
			}
			

		} catch (SQLException e) {
			System.out.println("No se pudo establecer la conección con a base de datos");
		}
		System.out.println(promociones);
		return promociones;
	}

}
