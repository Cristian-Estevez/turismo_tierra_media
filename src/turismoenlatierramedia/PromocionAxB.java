package turismoenlatierramedia;

import java.util.List;
import java.util.ListIterator;

public class PromocionAxB extends Promocion{

	//de la forma en que está implementado este constructor, la última atraccion de la lista que recibe como parámetro es la que vien de regalo
	
	public PromocionAxB(String nombre, TipoDeAtraccion tipo, List<Atraccion> atraccionesIncluidas) {
		super(nombre, tipo, atraccionesIncluidas);
		this.setCosto(this.calcularCosto(atraccionesIncluidas));
	}

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
