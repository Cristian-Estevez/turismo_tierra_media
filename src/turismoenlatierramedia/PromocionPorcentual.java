package turismoenlatierramedia;

import java.util.List;

public class PromocionPorcentual extends Promocion{

	public PromocionPorcentual(String nombre, TipoDeAtraccion tipo, double porcentajeDescuento, List<Atraccion> atraccionesIncluidas) {
		super(nombre, tipo, atraccionesIncluidas);
		this.costo = getCostoConDescuento(porcentajeDescuento, atraccionesIncluidas);
	}

	private double getCostoConDescuento(double porcentajeDescuento, List<Atraccion> atraccionesIncluidas) {
		double valorTotal = 0;
		for (Atraccion atraccion : atraccionesIncluidas) {
			valorTotal += atraccion.getCosto();
		}
		double descuentoTotal = (porcentajeDescuento * valorTotal) / 100; 
		return valorTotal - descuentoTotal;
	}

	@Override
	public String getTipoDePromocion() {
		return "Promocion Porcentual";
	}
}
