package turismoenlatierramedia;


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
	
}
