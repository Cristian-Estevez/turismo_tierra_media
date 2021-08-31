package turismoenlatierramedia;

import java.util.Iterator;
import java.util.List;

public class Promocion extends Producto {
	
	protected List<Atraccion> atraccionesIncluidas;

	public Promocion(String nombre, double tiempoDeDuracion, TipoDeAtraccion tipoDeAtraccion
			, List<Atraccion> atraccionesIncluidas) {
		super(nombre, tiempoDeDuracion, tipoDeAtraccion);
		this.atraccionesIncluidas = atraccionesIncluidas;
	}

	
	/**
	 * 
	 * @return devuelve la menor cantidad de plazas disponibles de las atracciones 
	 * de la lista atraccionesIncluidas 
	 */
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

	public void ocuparLugar() throws AtraccionException {		
		for (Atraccion atraccion : atraccionesIncluidas) {
            atraccion.ocuparPlaza();
		}
	}

	@Override
	public double getTiempoDeDuracion() {
		double tiempoTotalDeDuracion = 0;		
		for (Atraccion atraccion : atraccionesIncluidas) {
			tiempoTotalDeDuracion += atraccion.getTiempoDeDuracion();
		}
		return tiempoTotalDeDuracion;
	}

}
