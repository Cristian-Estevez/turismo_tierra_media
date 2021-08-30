package turismoenlatierramedia;

import java.util.List;

public class Promocion extends Producto {
	protected List<Atraccion> atraccionesIncluidas;
	protected String nombre;

	public Promocion(String nombre, double tiempoDeDuracion, TipoDeAtraccion tipoDeAtraccion,
			List<Atraccion> atraccionesIncluidas) {
		super(nombre, tiempoDeDuracion, tipoDeAtraccion);
		this.atraccionesIncluidas = atraccionesIncluidas;
	}

	public int getLugaresDisponibles() {
		int lugaresDisponibles = 0;
		int contador = 0;

		for (Atraccion atracciones : atraccionesIncluidas) {
			if (contador == 0) {

				lugaresDisponibles = atracciones.getLugaresDisponibles();
				contador++;
			}

			if (lugaresDisponibles > atracciones.getLugaresDisponibles()) {
				lugaresDisponibles = atracciones.getLugaresDisponibles();

			}
		}

		return lugaresDisponibles;

	}

	public void ocuparLugar(Atraccion[] atraccionesIncluidas) {
		for (int i = 0; i < atraccionesIncluidas.length; i++) {

		}
	}

	public double calcularTiempoDeDuracion(Atraccion[] atraccionesIncluidas) {
		double tiempoTotalDeDuracion = 0;
		for (Atraccion atraccion : atraccionesIncluidas) {
			tiempoTotalDeDuracion += atraccion.getTiempoDeDuracion();
		}
		return tiempoTotalDeDuracion;
	}

}
