package turismoenlatierramedia;

import java.util.ArrayList;
import java.util.List;

public class PromocionAbsoluta extends Promocion {

	public PromocionAbsoluta(String nombre, TipoDeAtraccion tipo, double costo, List<Atraccion> atraccionesIncluidas) {
		super(nombre, tipo, costo, atraccionesIncluidas);
		this.tiempoDeDuracion = calcularTiempoDeDuracion(atraccionesIncluidas);
	}

	private double calcularTiempoDeDuracion(List<Atraccion> lista) {
		double tiempoTotal = 0;
		for (Atraccion atraccion : lista) {
			tiempoTotal += atraccion.getTiempoDeDuracion();
		}
		return tiempoTotal;
	}
	
}
