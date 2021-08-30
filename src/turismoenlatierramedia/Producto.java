package turismoenlatierramedia;

/**
 * 
 * @author Nahuel Serantes Cortéz, Cristian Estevez
 *
 */
public class Producto {
	
	private String nombre;
	private double costo;
	private double tiempoDeduracion;
	private TipoDeAtraccion tipoDeAtraccion;
	
	public Producto(String nombre, double costo, double tiempoDeDuracion, TipoDeAtraccion tipoDeAtraccion) {
		this.nombre = nombre;
		this.costo = costo;
		this.tiempoDeduracion = tiempoDeDuracion;
		this.tipoDeAtraccion = tipoDeAtraccion;		
	}
	
	public double getCosto() {		
		return costo;
	}
	
	public void setCosto(double costo) {
		this.costo = costo;
	}
	
	public double getTiempoDeDuracion() {
		return tiempoDeduracion;
	}
	
	public void setTiempoDeduracion(double tiempoDeduracion) {
		this.tiempoDeduracion = tiempoDeduracion;
	}	

}
