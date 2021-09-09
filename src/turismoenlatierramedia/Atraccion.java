package turismoenlatierramedia;

import java.util.Objects;

public class Atraccion extends Producto {

	private int cupoDiario; // checkear
	private int plazasOcupadas;

	public Atraccion(String nombre, double costo, double tiempoDeDuracion, int cupo, TipoDeAtraccion tipoDeAtraccion) {
		super(nombre, costo, tiempoDeDuracion, tipoDeAtraccion);
		this.cupoDiario = cupo;
	}

	public String getNombre() {
		return super.getNombre();
	}

	public int getLugaresDisponibles() {
		return cupoDiario - plazasOcupadas;
	}

	/*
	 * Solo ocupa una plaza si hay lugares disponibles
	 */
	public void ocuparPlaza() {
		if (getLugaresDisponibles() > 0)
			plazasOcupadas++;
	}

	@Override
	protected boolean esPromocion() {
		return false;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(cupoDiario, plazasOcupadas);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Atraccion other = (Atraccion) obj;
		return cupoDiario == other.cupoDiario && plazasOcupadas == other.plazasOcupadas;
	}

}
