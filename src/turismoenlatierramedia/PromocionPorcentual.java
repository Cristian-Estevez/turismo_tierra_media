package turismoenlatierramedia;

import java.util.List;

public class PromocionPorcentual extends Promocion{

	public PromocionPorcentual(int NumeroId, String nombre, TipoDeAtraccion tipo, double porcentajeDescuento, List<Atraccion> atraccionesIncluidas) {
		super(NumeroId, nombre, tipo, atraccionesIncluidas);
		this.setCosto(getCostoConDescuento(porcentajeDescuento, atraccionesIncluidas));
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
