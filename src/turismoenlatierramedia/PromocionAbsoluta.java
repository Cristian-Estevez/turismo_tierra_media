package turismoenlatierramedia;

import java.util.List;

public class PromocionAbsoluta extends Promocion {

	public PromocionAbsoluta(int NumeroId, String nombre, TipoDeAtraccion tipo, double costo, List<Atraccion> atraccionesIncluidas) {
		super(NumeroId, nombre, tipo, costo, atraccionesIncluidas);
	}

	@Override
	public String getTipoDePromocion() {
		return "Promocion Absoluta";
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
