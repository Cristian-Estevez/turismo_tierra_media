package turismoenlatierramedia;

import java.util.ArrayList;
import java.util.List;

public class PromocionAbsoluta extends Promocion {

	public PromocionAbsoluta(String nombre, TipoDeAtraccion tipo, double costo, List<Atraccion> atraccionesIncluidas) {
		super(nombre, tipo, costo, atraccionesIncluidas);
	}

	@Override
	public String getTipoDePromocion() {
		return "Promocion Absoluta";
	}
	
}
