package turismoenlatierramedia;

import java.util.Objects;

public abstract class Producto {

	protected String nombre;
	protected double costo;
	protected double tiempoDeDuracion;
	protected TipoDeAtraccion tipoDeAtraccion;

	public Producto(String nombre, double costo
					, double tiempoDeDuracion
					, TipoDeAtraccion tipoDeAtraccion) {

		this.nombre = nombre;
		this.costo = costo;
		this.tiempoDeDuracion = tiempoDeDuracion;
		this.tipoDeAtraccion = tipoDeAtraccion;
	}

	public Producto(String nombre, double tiempoDeDuracion, TipoDeAtraccion tipoDeAtraccion) {
		this.nombre = nombre;
		this.tiempoDeDuracion = tiempoDeDuracion;
		this.tipoDeAtraccion = tipoDeAtraccion;
	}

	public Producto(String nombre, TipoDeAtraccion tipo, double costo) {
		this.nombre = nombre;
		this.tipoDeAtraccion = tipo;
		this.costo = costo;
	}

	public Producto(String nombre2, TipoDeAtraccion tipo) {
		this.nombre = nombre;
		this.tipoDeAtraccion = tipo;
	}

	public double getCosto() {
		return costo;
	}

	protected void setCosto(double costo) {
		this.costo = costo;
	}

	public double getTiempoDeDuracion() {
		return tiempoDeDuracion;
	}

	public void setTiempoDeduracion(double tiempoDeduracion) {
		this.tiempoDeDuracion = tiempoDeduracion;
	}

	public TipoDeAtraccion getTipo() {
		return tipoDeAtraccion;
	}

	protected abstract boolean esPromocion(); 
	
	protected abstract void ocuparPlaza() throws AtraccionException;

	@Override
	public int hashCode() {
		return Objects.hash(costo, nombre, tiempoDeDuracion, tipoDeAtraccion);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		return Double.doubleToLongBits(costo) == Double.doubleToLongBits(other.costo)
				&& Objects.equals(nombre, other.nombre)
				&& Double.doubleToLongBits(tiempoDeDuracion) == Double.doubleToLongBits(other.tiempoDeDuracion)
				&& tipoDeAtraccion == other.tipoDeAtraccion;
	}
	
	
}
