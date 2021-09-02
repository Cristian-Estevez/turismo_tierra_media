package turismoenlatierramedia;

import java.util.List;
import java.util.ListIterator;

public class PromocionAxB extends Promocion{

	//de la forma en que está implementado este constructor, la última atraccion de la lista que recibe como parámetro es la que vien de regalo
	
	public PromocionAxB(String nombre, TipoDeAtraccion tipo, List<Atraccion> atraccionesIncluidas) {
		super(nombre, tipo, atraccionesIncluidas);
		this.costo = calcularCosto(atraccionesIncluidas);
	}

	private double calcularCosto(List<Atraccion> atraccionesIncluidas) {
		double costo = 0;
		ListIterator<Atraccion> iter = atraccionesIncluidas.listIterator(atraccionesIncluidas.size());
		int count = 0;
		while(iter.hasPrevious()) {
			if (count == 0) {
				iter.previous();
				count++;
			}
			costo += iter.previous().getCosto();
		}
		return costo;
	}
}
