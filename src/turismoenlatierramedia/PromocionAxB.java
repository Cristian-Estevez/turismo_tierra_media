package turismoenlatierramedia;

import java.util.List;
import java.util.ListIterator;

public class PromocionAxB extends Promocion{

	/**
	 * 
	 * @param nombre, tipo, List<Atraccion> atraccionesIncluidas.
	 *	El constuctor llama al método calcularCosto para determinar su precio
	 * 
	 */
	
	public PromocionAxB(String nombre, TipoDeAtraccion tipo, List<Atraccion> atraccionesIncluidas) {
		super(nombre, tipo, atraccionesIncluidas);
		super.setCosto(this.calcularCosto(atraccionesIncluidas));
	}
	
	/**
	 * 
	 * @param atraccionesIncluidas
	 * @return la suma del costo de todas las atraccionesIncluidas 
	 * menos la última que será gratuita
	 */

	private double calcularCosto(List<Atraccion> atraccionesIncluidas) {
		double costo = 0;
		ListIterator<Atraccion> iter = atraccionesIncluidas.listIterator(atraccionesIncluidas.size() -1);
		while(iter.hasPrevious()) {
			costo += iter.previous().getCosto();
		}
		return costo;
	}

	@Override
	public String getTipoDePromocion() {
		return "Promocion AxB";
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		return true;
	}
	
	
}
