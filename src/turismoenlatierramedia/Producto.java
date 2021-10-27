package turismoenlatierramedia;

import java.util.Objects;

public abstract class Producto {
	
	
    private int NumeroId;
	private String nombre;
	private double costo;
	private double tiempoDeDuracion;
	private TipoDeAtraccion tipoDeAtraccion;

	public Producto(int NumeroId, String nombre, double costo
					, double tiempoDeDuracion
					, TipoDeAtraccion tipoDeAtraccion) {
        this.NumeroId = NumeroId;
		this.nombre = nombre;
		this.costo = costo;
		this.tiempoDeDuracion = tiempoDeDuracion;
		this.tipoDeAtraccion = tipoDeAtraccion;
	}

	public Producto(int NumeroId, String nombre, double tiempoDeDuracion, TipoDeAtraccion tipoDeAtraccion) {
		this.NumeroId = NumeroId;
		this.nombre = nombre;
		this.tiempoDeDuracion = tiempoDeDuracion;
		this.tipoDeAtraccion = tipoDeAtraccion;
	}

	public Producto(int NumeroId, String nombre, TipoDeAtraccion tipo, double costo) {
		this.NumeroId = NumeroId;
		this.nombre = nombre;
		this.tipoDeAtraccion = tipo;
		this.costo = costo;
	}

	public Producto(int NumeroId, String nombre, TipoDeAtraccion tipo) {
		this.NumeroId = NumeroId;
		this.nombre = nombre;
		this.tipoDeAtraccion = tipo;
	}
	
	public int getId() {
		return NumeroId;
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

	protected void setTiempoDeduracion(double tiempoDeduracion) {
		this.tiempoDeDuracion = tiempoDeduracion;
	}

	public TipoDeAtraccion getTipo() {
		return tipoDeAtraccion;
	}

	public String getNombre() {
		return nombre;
	}
	
	protected abstract boolean esPromocion(); 
	
	protected abstract String esPromocionOAtraccion();
	
	protected abstract String imprimeLoQueIncluye();
		
	
	protected abstract void ocuparPlaza();
	
	public abstract int getLugaresDisponibles();
	
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

	public abstract boolean incluye(Producto prod) ;
	
	
}
