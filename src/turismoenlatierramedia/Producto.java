package turismoenlatierramedia;

/**
 * 
 * @author Nahuel Serantes Cortéz, Cristian Estevez
 *
 */
public class Producto {
	
	protected String nombre;
	protected double costo;
	protected double tiempoDeDuracion;
	protected TipoDeAtraccion tipoDeAtraccion;
	
	public Producto(String nombre, double costo, double tiempoDeDuracion, TipoDeAtraccion tipoDeAtraccion) {
		this.nombre = nombre;
		this.costo = costo;
		this.tiempoDeDuracion = tiempoDeDuracion;
		this.tipoDeAtraccion = tipoDeAtraccion;		
	}
	
	public double getCosto() {		
		return costo;
	}
	
	public void setCosto(double costo) {
		this.costo = costo;
	}
	
	public double getTiempoDeDuracion() {
		return tiempoDeDuracion;
	}
	
	public void setTiempoDeduracion(double tiempoDeduracion) {
		this.tiempoDeDuracion = tiempoDeduracion;
	}	

}
