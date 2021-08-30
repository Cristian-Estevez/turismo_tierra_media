package turismoenlatierramedia;

public class Producto {
	
	private String nombre;
	private double costo;
	private double tiempoDeduracion;
	private TipoDeAtraccion tipoDeAtraccion;
	
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
