package turismoenlatierramedia;

import java.util.Objects;

public class Atraccion extends Producto {

	private int cupo; // checkear
 

	public Atraccion(int NumeroId, String nombre, double costo, double tiempoDeDuracion, int cupo, TipoDeAtraccion tipoDeAtraccion) {
		super(NumeroId, nombre, costo, tiempoDeDuracion, tipoDeAtraccion);
		this.cupo = cupo;
	}
	
	public String getNombre() {
		return super.getNombre();
	}
	
	public int getLugaresDisponibles() {
		return cupo;
	}

	public void ocuparPlaza() {
		if (getLugaresDisponibles() > 0)
			cupo--;
	}

	@Override
	protected boolean esPromocion() {
		return false;
	}
	
	@Override
	protected String esPromocionOAtraccion() {
		return "la atracción";
	}
	
	@Override
	protected String imprimeLoQueIncluye() {
		return "";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(cupo);
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
		return cupo == other.cupo;
	}
	
	public boolean incluye(Producto unProducto) {
		if (unProducto.esPromocion()) {
			return unProducto.incluye(this);
		}
		return this.equals(unProducto);
		
	}

}
