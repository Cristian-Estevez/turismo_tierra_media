package turismoenlatierramedia;

/**
 * 
 * @author Micaela Trisi
 *
 */

public class Atraccion extends Producto {

	private int cupoDiario;
	private int plazasOcupadas;

	public Atraccion(String nombre, double costo, double tiempoDeDuracion, int cupo, TipoDeAtraccion tipoDeAtraccion) {

		super(nombre, costo, tiempoDeDuracion, tipoDeAtraccion);
		this.cupoDiario = cupo;
	}

	public int getLugaresDisponibles() {
		return cupoDiario -= plazasOcupadas;
	}
	
	public int getCupoDiario() {
		return cupoDiario;
	}
	
	public int getPlazasOcupadas() {
		return plazasOcupadas;
	}

}
